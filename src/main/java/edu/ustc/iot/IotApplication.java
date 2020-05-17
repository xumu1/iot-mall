package edu.ustc.iot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 功能描述：
 *
 * @Author: xumu
 * @Date: 2020-5-17 16:08
 */
@SpringBootApplication
@MapperScan(basePackages = "edu.ustc.iot.dao")
public class IotApplication {
  public static void main(String[] args) {
    SpringApplication.run(IotApplication.class,args);
  }
}
