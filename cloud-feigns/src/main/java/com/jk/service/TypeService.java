package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "cloud-provider",fallback = ProductErrorTip.class)
public interface TypeService extends TypeServices{
}
