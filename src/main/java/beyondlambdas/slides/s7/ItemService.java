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

package beyondlambdas.slides.s7;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class ItemService {

    public Stream<Item> itemsMatching(final Predicate<Item> filter) {
        return allItems().stream()
                         .filter(filter);
    }

    public List<Item> allItems() {
        final List<Item> list = IntStream.range(0, 20)
                                         .mapToObj(value -> item(value, "Item " + value))
                                         .collect(collectingAndThen(toList(), ItemService::addDuplicate));
        Collections.shuffle(list);
        return Collections.unmodifiableList(list);
    }

    private static List<Item> addDuplicate(final List<Item> items) {
        final List<Item> duplicates = IntStream.range(0, 10)
                                               .mapToObj(i -> item(6, "Item " + 6 + " (" + i + ")"))
                                               .collect(toList());
        items.addAll(duplicates);
        return items;
    }

    private static Item item(final long id, final String name) {
        return new Item(id, name);
    }

}
