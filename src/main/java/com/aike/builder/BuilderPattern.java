package com.aike.builder;

/**
 * 建造者模式与抽象工厂模式有点相似，但是建造者模式返回一个完整的复杂产品，
 * 而抽象工厂模式返回一系列相关的产品；在抽象工厂模式中，
 * 客户端通过选择具体工厂来生成所需对象，而在建造者模式中，
 * 客户端通过指定具体建造者类型并指导Director类如何去生成对象，侧重于一步步构造一个复杂对象，然后将结果返回。
 * 如果将抽象工厂模式看成一个汽车配件生产厂，生成不同类型的汽车配件，
 * 那么建造者模式就是一个汽车组装厂，通过对配件进行组装返回一辆完整的汽车。
 */
public class BuilderPattern {
    public static void main(String[] args) {
        ActorController actorController = new ActorController(new AngelBuilder());
        Actor actor = actorController.construct();
        System.out.println(actor.getType());
        System.out.println(actor.getSex());
    }
}
//Actor角色类：复杂产品，考虑到代码的可读性，只列出部分成员属性，且成员属性的类型均为String，真实情况下，有些成员属性的类型需自定义
class Actor {
    private  String type; //角色类型
    private  String sex; //性别

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
//角色建造器：抽象建造者
abstract class ActorBuilder{
    protected Actor actor = new Actor();
    abstract void builderType();
    abstract void builderSex();
    Actor createActor(){
        return actor;
    }
}
//英雄角色建造器：具体建造者
class HeroBuilder extends ActorBuilder{
    @Override
    void builderType() {
        actor.setType("英雄");
    }

    @Override
    void builderSex() {
        actor.setSex("女");
    }
}

//天使角色建造器：具体建造者
class AngelBuilder extends ActorBuilder {
    @Override
    void builderType() {
        actor.setType("天使");
    }

    @Override
    void builderSex() {
        actor.setSex("女");
    }
}

class ActorController{
    ActorBuilder actorBuilder;
    public ActorController(){

    }
    public ActorController(ActorBuilder builder) {
        this.actorBuilder = builder;
    }

    Actor construct(ActorBuilder builder){
        builder.builderType();
        builder.builderSex();
        return builder.createActor();
    }
    Actor construct(){
        actorBuilder.builderType();
        actorBuilder.builderSex();
        return actorBuilder.createActor();
    }
}





