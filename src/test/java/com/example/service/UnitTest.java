package com.example.service;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.annotation.*;

@Inherited
@Documented
@Tag("unit")
@Target({ElementType.TYPE})
@ExtendWith(MockitoExtension.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnitTest {
}
