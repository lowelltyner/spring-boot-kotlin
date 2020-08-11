package com.example.demo

import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    private val counter = AtomicLong()
    private val template = "Hello, %s!"

    @RequestMapping("/greeting")
    fun getGreeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), String.format(template, name))
    }

    @GetMapping("/got")
    fun getGot(): Greeting {
        return Greeting(counter.decrementAndGet(), template.decapitalize())
    }

    @PostMapping("/reset")
    fun reset(): Greeting {
        counter.set(0)
        return Greeting(counter.get(), template.decapitalize())
    }
}