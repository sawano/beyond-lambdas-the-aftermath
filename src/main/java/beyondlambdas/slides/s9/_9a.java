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

import org.junit.Test;

import java.util.function.Function;

import static beyondlambdas.slides.s9.User.someUser;
import static java.lang.String.format;

public class _9a {

    static Integer numberOfFreeApples(final User user,
                                      final Function<User, Integer> foodRatio) {
        return 2 * foodRatio.apply(user);
    }

    @Test
    public void _() {

        final Function<User, Integer> foodRatioForVisitors = u -> u.age() > 12 ? 2 : 1;

        final int numberOfFreeApples = numberOfFreeApples(someUser(), foodRatioForVisitors);

        System.out.println(format("Number of free apples: %d", numberOfFreeApples));

    }

}
