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

package beyondlambdas.slides.s8_1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import static se.sawano.java.commons.lang.validate.Validate.inclusiveBetween;
import static se.sawano.java.commons.lang.validate.Validate.notBlank;

class User {
    private final long id;
    private final String name;

    @JsonCreator
    public User(@JsonProperty("id") final long id, @JsonProperty("name") final String name) {
        inclusiveBetween(1, 20, id, "Id must be between 1 and 20. Was: " + id);
        this.id = id;
        this.name = notBlank(name).trim();
    }

    public long id() {
        return id;
    }

    public String name() {
        return name;
    }
}
