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

package beyondlambdas.slides.s9;

import static se.sawano.java.commons.lang.validate.Validate.isTrue;

class User {

    public static User someUser() {
        return new User(12);
    }

    private final int age;

    public User(final int age) {
        isTrue(age > 0);
        this.age = age;
    }

    public int age() {
        return age;
    }
}
