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

@SuppressWarnings("Convert2MethodRef")
public class _9c {

    @FunctionalInterface
    interface FoodRatioStrategy {

        Integer ratioFor(User user);
    }

    static Integer numberOfFreeApples(final User user,
                                      final FoodRatioStrategy ratioStrategy) {
        return 2 * ratioStrategy.ratioFor(user);
    }

    @Test
    public void _() {

        final FoodRatioStrategy foodRatioForVisitors = user -> user.age() > 12 ? 2 : 1;
        final Function<User, Integer> age = (user) -> user.age();

        final Integer numberOfFreeApples_1 = numberOfFreeApples(someUser(), foodRatioForVisitors);
        //final Integer numberOfFreeApples_2 = numberOfFreeApples(someUser(), age);

        System.out.println(format("Number of free apples (1): %d", numberOfFreeApples_1));
    }

}
