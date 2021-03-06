/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.devwantjusthavefun.springhateoascustomizejackson;

import java.time.Instant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Greg Turnquist
 */
@Component
class DatabaseLoader
{

    @Bean
    CommandLineRunner InitDatabase(final EmployeeRepository repository)
    {

        return args -> {
            repository.save(new Employee("Frodo", "ring bearer", Instant.now()));
            repository.save(new Employee("Bilbo", "burglar", Instant.now()));
        };
    }
}
