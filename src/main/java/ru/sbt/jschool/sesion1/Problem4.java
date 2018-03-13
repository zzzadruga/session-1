/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.sbt.jschool.sesion1;

/**
 */
public class Problem4 {
    public static void main(String[] args) {
        PropertyManager propertyManager = new PropertyManager(args);

        String countStr = propertyManager.value("JSCHOOL_COUNT");

        if (countStr == null) {
            System.out.println("Property value should be defined as one of following ways:");
            System.out.println("   1. Command line arguments JSCHOOL1_COUNT=XXX.");
            System.out.println("   2. Jvm property -DJSCHOOL1_COUNT=XXX");
            System.out.println("   3. Environment variable JSCHOOL1_COUNT=XXX");
            System.out.println("   4. In property file from JSCHOOL1_PROPERTIES_FILE=XXX, where XXX is path to property file.");

            return;
        }

        int count = Integer.valueOf(countStr);

        for (int i=0; i<count; i++)
            System.out.println("Hello, World!");
    }
}
