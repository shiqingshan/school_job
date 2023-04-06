package com.scj.mpgen;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;
import java.util.Scanner;

public class MpFastAutoGenerator {
    public static void main(String[] args) {

        String projectPath = "D:\\java_workspace\\school_job\\scj-mp-generator";

        String url = "jdbc:mysql://192.168.71.102:3306/school_job?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai";

        FastAutoGenerator.create(url, "root", "123456")
                .globalConfig(builder -> {
                    builder
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath+"/src/main/java/com/scj/mpgen/gen"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.scj.generator") // 设置父包名

                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath+"/src/main/resources")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("scj_user") // 设置需要生成的表名
                            .addTablePrefix("scj_"); // 设置过滤表前缀
                    builder.entityBuilder()
                            .enableLombok() // 开启lombok
                            .enableChainModel()// 开启链式模式
                            .superClass("com.sc.common.base.BaseDO")
                            .addSuperEntityColumns("creator","create_time","updater","update_time","deleted")
                            .addIgnoreColumns("creator","create_time","updater","update_time","deleted")
                            .logicDeleteColumnName("deleted")
                            .logicDeletePropertyName("deleted")
                            .enableFileOverride()
                            .enableTableFieldAnnotation()
                            .formatFileName("%sDO");
                    builder.controllerBuilder().enableRestStyle();

                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
