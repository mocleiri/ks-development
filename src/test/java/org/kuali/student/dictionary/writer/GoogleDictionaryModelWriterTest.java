/*
 * Copyright 2009 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may	obtain a copy of the License at
 *
 * 	http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.dictionary.writer;

import org.kuali.student.dictionary.writer.DictionaryModelWriter;
import org.kuali.student.dictionary.model.impl.DictionaryModelCache;
import org.kuali.student.dictionary.model.impl.DictionaryModelLoader;
import org.kuali.student.dictionary.model.DictionaryModel;
import org.kuali.student.dictionary.model.spreadsheet.GoogleSpreadsheetReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nwright
 */
public class GoogleDictionaryModelWriterTest
{

 public GoogleDictionaryModelWriterTest ()
 {
 }

 @BeforeClass
 public static void setUpClass ()
  throws Exception
 {
 }

 @AfterClass
 public static void tearDownClass ()
  throws Exception
 {
 }

 @Before
 public void setUp ()
 {
 }

 @After
 public void tearDown ()
 {
 }

 //private static String USER_ID = "nwright@mit.edu";
 //private static String PASSWORD = "xxxxx";
 private static String SPREADSHEET_KEY = "tSdKqlIJ1piKNBie4_H0hoA";

 /**
  * Test of write method, of class DictionaryWriter.
  */
 @Test
 public void testTrue ()
 {
  assertEquals (true, true);
 }

 /**
  * Test of write method, of class DictionaryWriter.
  */
// @Test
 public void testWriteGoogleDictionary ()
 {
  System.out.println ("writeGoogleDictionary");
  File file =
   new File ("src/resources/dictionary/lu-dictionary-config-generated-google.xml");
  PrintStream out;
  try
  {
   out = new PrintStream (file);
  }
  catch (FileNotFoundException ex)
  {
   throw new RuntimeException (ex);
  }
  GoogleSpreadsheetReader reader = new GoogleSpreadsheetReader ();
  // don't need user name and password if spreadsheet is published
  //reader.setUserCredentials (USER_ID, PASSWORD);
  reader.setKey (SPREADSHEET_KEY);
  reader.setVisibility ("public");
  reader.setProjection ("values");
  DictionaryModel spreadsheet = new DictionaryModelLoader (reader, null);
  spreadsheet = new DictionaryModelCache (spreadsheet);
  DictionaryModelWriter instance = new DictionaryModelWriter (out, spreadsheet);
  instance.write ();
  out.close ();
  assertEquals (true, true);
 }

}