/*
 * Copyright 2003-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package groovy

class ArrayParamMethodTest extends GroovyTestCase implements DummyInterface {

    void testMethodCall() {
        def array = "a b c".split(' ')
        
        assert array.size() == 3
        
        methodWithArrayParam(array)
    }
    
    void methodWithArrayParam(String[] args) {
        println("first item: ${args[0]}")
        
        // lets turn it into a list
        def list = args.toList()
        assert list instanceof java.util.List
        list[4] = "e"
        
        assert list == ["a", "b", "c", null, "e"]
        
        println("Created list ${list}")
    }
}