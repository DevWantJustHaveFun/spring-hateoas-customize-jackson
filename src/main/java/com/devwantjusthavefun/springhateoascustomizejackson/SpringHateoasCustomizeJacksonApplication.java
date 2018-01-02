package com.devwantjusthavefun.springhateoascustomizejackson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        HypermediaAutoConfiguration.class,
})
public class SpringHateoasCustomizeJacksonApplication
{

    public static void main(final String[] args)
    {
        SpringApplication.run(SpringHateoasCustomizeJacksonApplication.class, args);
    }
}
