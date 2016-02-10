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

package beyondlambdas.slides.s14;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class _14 {
    private final String pattern;

    public _14(final String pattern) {
        this.pattern = pattern;
    }

    public List<String> allMatchingElements(final List<String> elements) {
        return elements.stream()
                       .filter(e -> e.contains(pattern))
                       .collect(toList());
    }

}
