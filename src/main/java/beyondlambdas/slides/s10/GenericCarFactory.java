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

package beyondlambdas.slides.s10;

import java.util.function.Function;

import static se.sawano.java.commons.lang.validate.Validate.notNull;

public class GenericCarFactory implements CarFactory {
    private final Function<CarFactory, Engine> engineStrategy;

    public GenericCarFactory(final Function<CarFactory, Engine> engineStrategy) {
        this.engineStrategy = notNull(engineStrategy);
    }

    public static Car createCarWith(final Function<CarFactory, Engine> engineStrategy) {
        final Engine engine = engineStrategy.apply(new GenericCarFactory(engineStrategy));

        return new GenericCar(engine);
    }

    @Override
    public Generator generator() {
        final Engine engine = engineStrategy.apply(this);

        return engine.horsepower() > 400 ? new BadAssGenerator() : new NormalGenerator();
    }

    private static final class GenericCar implements Car {
        private final Engine engine;

        private GenericCar(final Engine engine) {
            this.engine = notNull(engine);
        }

        @Override
        public Engine engine() {
            return engine;
        }
    }

    private static final class BadAssGenerator implements Generator {
        //Bad Ass generator stuff
    }

    private static final class NormalGenerator implements Generator {
        //Normal generator stuff
    }
}
