/**
 * Copyright 2010 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.kuali.student.lum.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import static org.junit.Assert.*;
import org.kuali.student.core.assembly.data.Metadata;
import org.kuali.student.core.assembly.dictionary.MetadataFormatter;
import org.kuali.student.core.assembly.dictionary.MetadataServiceImpl;
import org.kuali.student.core.dictionary.service.DictionaryService;
import org.kuali.student.core.dictionary.service.impl.DictionaryServiceImpl;
import org.kuali.student.core.proposal.dto.ProposalInfo;
import org.kuali.student.core.search.dto.SearchTypeInfo;
import org.kuali.student.core.statement.dto.ReqCompFieldInfo;
import org.kuali.student.core.statement.dto.ReqComponentInfo;
import org.kuali.student.core.statement.dto.StatementInfo;
import org.kuali.student.lum.course.dto.CourseInfo;
import org.kuali.student.lum.program.dto.MajorDisciplineInfo;
import org.kuali.student.lum.program.dto.ProgramRequirementInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMetadataServiceDictionary
{

 @Test
 public void testMetadataService ()
 {
  Set<String> startingClasses = new LinkedHashSet ();
  Map<String, Set<String>> types = new LinkedHashMap ();
  startingClasses.add (CourseInfo.class.getName ());
  startingClasses.add (MajorDisciplineInfo.class.getName ());
  startingClasses.add (ProgramRequirementInfo.class.getName ());
  startingClasses.add (ProposalInfo.class.getName ());
  startingClasses.add (StatementInfo.class.getName ());
  startingClasses.add (ReqComponentInfo.class.getName ());
  startingClasses.add (ReqCompFieldInfo.class.getName ());
  startingClasses.add ("cluset");
  startingClasses.add ("courseSet");
  startingClasses.add ("programSet");
  startingClasses.add ("testSet");
  startingClasses.add ("search");
  startingClasses.add ("browse");


  //  startingClasses.add (StatementTreeViewInfo.class);

  Set<String> typesForClass = new LinkedHashSet ();
  types.put (ReqCompFieldInfo.class.getName (), typesForClass);
  typesForClass.add ("kuali.reqComponent.field.type.gpa");
  typesForClass.add ("kuali.reqComponent.field.type.operator");
  typesForClass.add ("kuali.reqComponent.field.type.clu.id");
  typesForClass.add ("kuali.reqComponent.field.type.course.clu.id");
  typesForClass.add ("kuali.reqComponent.field.type.program.clu.id");
  typesForClass.add ("kuali.reqComponent.field.type.test.clu.id");
  typesForClass.add ("kuali.reqComponent.field.type.test.score");
  typesForClass.add ("kuali.reqComponent.field.type.cluSet.id");
  typesForClass.add ("kuali.reqComponent.field.type.course.cluSet.id");
  typesForClass.add ("kuali.reqComponent.field.type.program.cluSet.id");
  typesForClass.add ("kuali.reqComponent.field.type.test.cluSet.id");
  typesForClass.add ("kuali.reqComponent.field.type.person.id");
  typesForClass.add ("kuali.reqComponent.field.type.org.id");
  typesForClass.add ("kuali.reqComponent.field.type.value.positive.integer");
  typesForClass.add ("kuali.reqComponent.field.type.gradeType.id");
  typesForClass.add ("kuali.reqComponent.field.type.grade.id");
  typesForClass.add ("kuali.reqComponent.field.type.durationType.id");
  typesForClass.add ("kuali.reqComponent.field.type.duration");

  DictionaryService courseDictService = new DictionaryServiceImpl (
    "classpath:ks-courseInfo-dictionary-context.xml");
  DictionaryService progDictService = new DictionaryServiceImpl (
    "classpath:ks-programInfo-dictionary-context.xml");
  DictionaryService cluSetDictService = new DictionaryServiceImpl (
    "classpath:ks-cluSetInfo-dictionary-context.xml");
  for (String objType : cluSetDictService.getObjectTypes ())
  {
   System.out.println ("Cluset has object type=" + objType);
  }
  DictionaryService proposalDictService = new DictionaryServiceImpl (
    "classpath:ks-proposalInfo-dictionary-context.xml");
  DictionaryService statementDictService = new DictionaryServiceImpl (
    "classpath:ks-statement-dictionary-context.xml");
  MetadataServiceImpl metadataService = new MetadataServiceImpl (
    courseDictService,
    progDictService,
    cluSetDictService,
    proposalDictService,
    statementDictService);
  metadataService.setUiLookupContext ("classpath:lum-ui-lookup-context.xml");
  List<String> errors = new ArrayList ();
  for (String className : startingClasses)
  {
   String outFile = "target/metadata-for-" + className + ".txt";
   File file = new File (outFile);
   OutputStream outputStream = null;
   try
   {
    outputStream = new FileOutputStream (file, false);
   }
   catch (FileNotFoundException ex)
   {
    throw new RuntimeException (ex);
   }
   PrintStream out = new PrintStream (outputStream);
   out.println ("(!) This page was automatically generated on "
                + new Date ());
   out.println ("DO NOT UPDATE MANUALLY!");
   out.println ("");
   out.println (
     "This page represents a formatted view of the lum ui dictionary for "
     + className);
   out.println ("");
   out.println ("----");
   out.println ("{toc}");
   out.println ("----");
//   out.println ("getting meta data for " + className);
   Metadata metadata = metadataService.getMetadata (className);
   assertNotNull (metadata);
   errors.addAll (this.validateMetadata (metadata, className, null));
   MetadataFormatter formatter = new MetadataFormatter (className,
                                                        metadata, null,
                                                        null, new HashSet (),
                                                        1);
   out.println (formatter.formatForWiki ());
   if (types.get (className) == null)
   {
    continue;
   }
   for (String type : types.get (className))
   {
    System.out.println ("*** Generating formatted version for " + type);
    metadata = metadataService.getMetadata (className, type, (String) null);
    assertNotNull (metadata);
    errors.addAll (this.validateMetadata (metadata, className, type));
    formatter = new MetadataFormatter (className,
                                       metadata, type,
                                       null, new HashSet (),
                                       1);
    out.println (formatter.formatForWiki ());
   }
   out.close ();
  }
  if (errors.size () > 0)
  {
   for (String error : errors)
   {
    System.out.println ("error: " + error);
   }
   System.out.println (errors.size () + " errors found when validating metadata");
//   fail (errors.size () + " errors found when validating metadata");
  }
 }

 private SearchTypeInfo getSearchTypeInfo (String searchType)
 {
  return this.getSearchInfoTypeMap ().get (searchType);
 }
 private Map<String, SearchTypeInfo> searchInfoTypeMap = null;

 private Map<String, SearchTypeInfo> getSearchInfoTypeMap ()
 {
  if (this.searchInfoTypeMap != null)
  {
   return this.searchInfoTypeMap;
  }
  String[] searchConfigFiles =
  {
   "lu", "lo", "lrc", "organization", "atp", "em"
  };
  for (int i = 0; i < searchConfigFiles.length; i ++)
  {
   System.out.println ("loading search configurations for "
                       + searchConfigFiles[i]);
   ApplicationContext ac = new ClassPathXmlApplicationContext (
     "classpath:" + searchConfigFiles[i] + "-search-config.xml");
   if (searchInfoTypeMap == null)
   {
    searchInfoTypeMap = ac.getBeansOfType (SearchTypeInfo.class);
   }
   else
   {
    searchInfoTypeMap.putAll (ac.getBeansOfType (SearchTypeInfo.class));
   }
  }
  return searchInfoTypeMap;
 }
 private MetadataServiceDictionaryValidator validator = null;

 private MetadataServiceDictionaryValidator getValidator ()
 {
  if (validator == null)
  {
   validator = new MetadataServiceDictionaryValidator ();
  }
  return validator;
 }

 private List<String> validateMetadata (Metadata md, String name, String type)
 {
  return getValidator ().validateMetadata (md, name, type);
 }
}
