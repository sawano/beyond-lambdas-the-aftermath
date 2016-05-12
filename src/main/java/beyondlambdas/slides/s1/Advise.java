/*
 * Copyright 2016 the original author or authors.
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

package beyondlambdas.slides.s1;

final class Advise {
    public static Advise currentAdvise() {
        return new Advise();
    }

    public String cheap() {
        System.out.println("Getting cheap advice...");
        return "Cheap message";
    }

    public String expensive() {
        System.out.println("Getting expensive advice...");
        return "Good advise don't come cheap...";
    }

}
