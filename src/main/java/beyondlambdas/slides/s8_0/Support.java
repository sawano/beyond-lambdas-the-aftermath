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

package beyondlambdas.slides.s8_0;

import beyondlambdas.slides.s7.Item;
import beyondlambdas.slides.s7.ItemService;

import java.util.List;

class Support {

    public static void givenALoggedInUser(final UserService userService) {
        userService.setCurrentUser(new User(123L));
    }

    public static List<Item> itemsToBuy() {
        return new ItemService().allItems();
    }
}
