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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Support {

    private static final ObjectReader OBJECT_READER = new ObjectMapper().readerFor(User.class);

    public static Stream<String> jsonData() {
        return IntStream.rangeClosed(1, 20)
                        .mapToObj(Support::item);
    }

    public static Stream<String> badJsonData() {
        final List<Integer> integers = IntStream.rangeClosed(1, 20).boxed().collect(toList());
        integers.set(12, 21);
        return integers.stream()
                       .map(Support::item);
    }

    private static String item(final int id) {
        return "{\"id\":\"" + id + "\", \"name\":\"item-" + id + "\"}";
    }

    public static User parseJson(final String json) {
        try {
            final User user = OBJECT_READER.readValue(json);
            System.out.println("Parsed user with id: " + user.id());
            return user;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void sendCouponTo(final List<User> users) {
        // Sends a great offer to the given users
        System.out.println("15%-off coupon sent to " + users.size() + " users!");
    }

    public static void trackError(final Exception e) {
        System.out.println("ERROR: Problem parsing user: " + e.getCause().getCause().getMessage());
    }

}
