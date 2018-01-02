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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Greg Turnquist
 */
@Entity
class Employee
{
    @Id
    @GeneratedValue
    Long id;
    private String name;
    private String role;
    private Instant creationDate;

    Employee()
    {
    }

    Employee(final String name, final String role, final Instant creationDate)
    {
        this.name = name;
        this.role = role;
        this.creationDate = creationDate;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public String getRole()
    {
        return role;
    }

    public Instant getCreationDate()
    {
        return creationDate;
    }

}
