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

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Greg Turnquist
 */
@RestController
class EmployeeController
{

    private final EmployeeRepository repository;

    public EmployeeController(final EmployeeRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping(value = "/employees", produces = MediaTypes.HAL_JSON_VALUE)
    ResponseEntity<?> findAll()
    {

        return ResponseEntity.ok(new Resources<>(
                StreamSupport.stream(repository.findAll().spliterator(), false)
                        .map(employee -> new Resource<>(
                                employee,
                                linkTo(methodOn(EmployeeController.class).findOne(employee.getId())).withSelfRel(),
                                linkTo(methodOn(EmployeeController.class).findAll()).withRel("employees")))
                        .collect(Collectors.toList()),
                linkTo(methodOn(EmployeeController.class).findAll()).withSelfRel()));
    }

    @GetMapping(value = "/employees/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    ResponseEntity<?> findOne(@PathVariable final Long id)
    {

        return ResponseEntity.ok(
                new Resource<>(
                        repository.findOne(id),
                        linkTo(methodOn(EmployeeController.class).findOne(id)).withSelfRel(),
                        linkTo(methodOn(EmployeeController.class).findAll()).withRel("employees")));
    }

}
