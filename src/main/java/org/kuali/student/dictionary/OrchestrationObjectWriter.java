/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kuali.student.dictionary;

import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JEnumConstant;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JVar;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.kuali.student.lum.lu.assembly.data.client.ModifiableData;
import org.kuali.student.lum.lu.assembly.data.client.PropertyEnum;

/**
 *
 * @author nwright
 */
public class OrchestrationObjectWriter
{

 private DictionaryModel model;
 private String directory;
 public static final String ROOT_PACKAGE = "org.kuali.student.orchestration";

 public OrchestrationObjectWriter (DictionaryModel model, String directory)
 {
  this.model = model;
  this.directory = directory;
 }

 /**
  * Write out the entire file
  * @param out
  */
 public void write ()
 {
  this.validate ();

  JCodeModel jcm = new JCodeModel ();
  Map<String, JDefinedClass> map = new HashMap ();
  List<OrchestrationObject> orchObjs =
   getOrchestrationObjectsFromMessageStructures ();
  addClassToModel (jcm, map, orchObjs);
  addBeanMethodsToModel (jcm, map, orchObjs);
  try
  {
   jcm.build (new File (directory));
  }
  catch (IOException ex)
  {
   throw new DictionaryValidationException (ex);
  }
 }

 private void addClassToModel (JCodeModel jcm, Map<String, JDefinedClass> map,
                               List<OrchestrationObject> orchObjs)
 {
  for (OrchestrationObject oo : orchObjs)
  {
   try
   {
    String className = calcFullyQualifiedClassName (oo.getName ());
    System.out.println ("Creating " + className);
    JDefinedClass mainClass = jcm._class (className, ClassType.CLASS);
    map.put (oo.getName (), mainClass);
    mainClass._extends (ModifiableData.class);
    mainClass.field (JMod.PRIVATE + JMod.STATIC + JMod.FINAL, long.class, "serialVersionUID", JExpr.
     lit (1l));

    JDefinedClass enumClass = mainClass._enum ("Properties");
    enumClass._implements (PropertyEnum.class);
    for (OrchestrationObjectField field : oo.getFields ())
    {
     JEnumConstant ec =
      enumClass.enumConstant (calcCONSTANT (field.getName ()));
     ec.arg (JExpr.lit (field.getName ()));

    }
    JFieldVar keyVar =
     enumClass.field (JMod.PRIVATE + JMod.FINAL, String.class, "key");

    JMethod enumConstructor = enumClass.constructor (JMod.PRIVATE);
    JVar keyParam = enumConstructor.param (JMod.FINAL, String.class, "ky");
    enumConstructor.body ().assign (keyVar, keyParam);

    JMethod getKeyMethod =
     enumClass.method (JMod.PUBLIC, String.class, "getKey");
    getKeyMethod.annotate (Override.class);
    getKeyMethod.body ()._return (keyVar);


    JMethod mainConstructor = mainClass.constructor (JMod.PUBLIC);
    // TODO: ask Wil if we want to really use the class name as the key
    // TODO: figure out how to insert a comment into the JBlock
    mainConstructor.body ().directStatement ("super (" + oo.getName () +
     ".class.getName ());");
   }
   catch (JClassAlreadyExistsException ex)
   {
    throw new DictionaryValidationException (ex);
   }
  }
 }

 private void addBeanMethodsToModel (JCodeModel jcm,
                                     Map<String, JDefinedClass> map,
                                     List<OrchestrationObject> orchObjs)
 {
  for (OrchestrationObject oo : orchObjs)
  {
   System.out.println ("Adding Bean Methods to Model " + oo.getName ());
   for (OrchestrationObjectField field : oo.getFields ())
   {
    System.out.println ("Adding Bean Method to Model " + oo.getName () + "." +
     field.getName () + "\t" + field.getType ());
    addBeanMethodToModel (map.get (oo.getName ()), field, map);
   }
  }
 }

 private void addBeanMethodToModel (JDefinedClass mainClass,
                                    OrchestrationObjectField field,
                                    Map<String, JDefinedClass> map)
 {
  XmlType xmlType = new ModelFinder (model).findXmlType (field.getType ());
  if (xmlType == null)
  {
   throw new DictionaryValidationException ("No XmlType found for field type " +
    field.getType () + " " + field.getName ());
  }
  Object fieldType = null;
  if (xmlType.getPrimitive ().equals ("Primitive"))
  {
   if (field.getType ().equals ("string"))
   {
    fieldType = String.class;
   }
   else if (field.getType ().equals ("date"))
   {
    fieldType = Date.class;
   }
   else if (field.getType ().equals ("dateTime"))
   {
    // TODO: figure out what the right class is for this
    fieldType = Date.class;
   }
   else if (field.getType ().equals ("boolean"))
   {
    fieldType = Boolean.class;
   }
   else if (field.getType ().equals ("integer"))
   {
    fieldType = Integer.class;
   }
   else if (field.getType ().equals ("long"))
   {
    fieldType = Long.class;
   }
   else
   {
    throw new DictionaryValidationException ("Unknown/handled field type " +
     field.getType () + " " + field.getName ());
   }
  }
  else if (xmlType.getPrimitive ().equals ("Mapped String"))
  {
   fieldType = String.class;
  }
  else if (xmlType.getPrimitive ().equals ("Complex"))
  {
   fieldType = map.get (field.getType ());
   if (fieldType == null)
   {
    throw new DictionaryValidationException ("Complex field type " +
     field.getType () + " " + field.getName () + " not found in map");
   }
  }
  else
  {
   throw new DictionaryValidationException ("Unknown/unhandled primitive " +
    xmlType.getPrimitive () + " for field type " +
    field.getType () + " " + field.getName ());
  }

  // getter
  JMethod getMethod = null;
  if (fieldType instanceof Class)
  {
   Class clazz = (Class) fieldType;
   getMethod =
    mainClass.method (JMod.PUBLIC, clazz, calcGetFieldMethodName (field.getName ()));
  }
  else
  {
   JDefinedClass jdc = (JDefinedClass) fieldType;
   getMethod =
    mainClass.method (JMod.PUBLIC, jdc, calcGetFieldMethodName (field.getName ()));
  }

  getMethod.body ().directStatement ("return super.get(Properties." +
   calcCONSTANT (field.getName ()) + ".getKey());");

  // setter
  JMethod setMethod =
   mainClass.method (JMod.PUBLIC, String.class, calcSetFieldMethodName (field.
   getName ()));
  JVar valueParam = null;
  if (fieldType instanceof Class)
  {
   Class clazz = (Class) fieldType;
   valueParam = setMethod.param (clazz, "value");
  }
  else
  {
   JDefinedClass jdc = (JDefinedClass) fieldType;
   valueParam = setMethod.param (jdc, "value");
  }
  setMethod.body ().directStatement ("super.set(Properties." +
   calcCONSTANT (field.getName ()) + ".getKey(), value);");
 }

 public static String calcGetFieldMethodName (String name)
 {
  return "get" + name.substring (0, 1).toUpperCase () + name.substring (1);
 }

 public static String calcSetFieldMethodName (String name)
 {
  return "set" + name.substring (0, 1).toUpperCase () + name.substring (1);
 }

 public static String calcFullyQualifiedClassName (String name)
 {
  return ROOT_PACKAGE + "." + name.substring (0, 1).toUpperCase () + name.
   substring (1) + "Data";
 }

 public static String calcCONSTANT (String name)
 {
  StringBuffer buf = new StringBuffer (name.length () + 2);
  for (int i = 0; i < name.length (); i ++)
  {
   char c = name.charAt (i);
   if (Character.isUpperCase (c))
   {
    buf.append ('_');
   }
   buf.append (Character.toUpperCase (c));
  }
  return buf.toString ();
 }

 private void validate ()
 {
  Collection<String> errors =
   new OrchestrationModelValidator (model).validate ();
  if (errors.size () > 0)
  {
   StringBuffer buf = new StringBuffer ();
   buf.append (errors.size () +
    " errors found while validating the spreadsheet.");
   int cnt = 0;
   for (String msg : errors)
   {
    cnt ++;
    buf.append ("\n");
    buf.append ("*error*" + cnt + ":" + msg);
   }
   throw new DictionaryValidationException (buf.toString ());
  }
 }

 private List<OrchestrationObject> getOrchestrationObjectsFromMessageStructures ()
 {
  List<OrchestrationObject> list = new ArrayList ();
  for (XmlType xmlType : model.getXmlTypes ())
  {
   if (xmlType.getPrimitive ().equals ("Complex"))
   {
    OrchestrationObject obj = new OrchestrationObject ();
    list.add (obj);
    obj.setName (xmlType.getName ());
    List<OrchestrationObjectField> fields = new ArrayList ();
    obj.setFields (fields);
    for (MessageStructure ms : model.getMessageStructures ())
    {
     if (ms.getXmlObject ().equals (xmlType.getName ()))
     {
      OrchestrationObjectField field = new OrchestrationObjectField ();
      fields.add (field);
      field.setName (ms.getShortName ());
      field.setType (calcType (ms.getType ()));
      field.setIsList (calcIsList (ms.getType ()));
     }
    }
   }
  }
  return list;
 }

 public boolean calcIsList (String type)
 {
  if (type.endsWith ("List"))
  {
   return true;
  }
  return false;
 }

 public String calcType (String type)
 {
  if (type.endsWith ("List"))
  {
   type = type.substring (0, type.length () - "List".length ());
  }
  return type;
 }

}
