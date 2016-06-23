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

import org.junit.Test;

import static beyondlambdas.slides.s8_0.Support.givenALoggedInUser;
import static beyondlambdas.slides.s8_0.Support.itemsToBuy;
import static java.lang.String.format;
import static se.sawano.java.commons.lang.validate.Validate.validState;

//16
public class _8_0a {

    final UserService userService = new UserService();
    final OrderService orderService = new OrderService();

    @Test
    public void _() {
        givenALoggedInUser(userService);

        itemsToBuy().stream()
                    .map(item -> new Order(item.id(), currentUser().id()))
                    .forEach(orderService::sendOrder);

        System.out.println(format("Sent %d orders", orderService.sentOrders()));
    }

    User currentUser() {
        final User user = userService.currentUser();
        validState(user != null, "No current user found");
        return user;
    }
}
