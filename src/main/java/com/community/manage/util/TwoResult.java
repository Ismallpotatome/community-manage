package com.community.manage.util;

import lombok.Data;

@Data
public class TwoResult<T> {
    public T data;
    public int number;
}
