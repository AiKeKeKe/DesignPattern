package com.aike.decorator;

/**
 * 装饰模式(Decorator Pattern)：动态地给一个对象增加一些额外的职责，就增加对象功能来说，装饰模式比生成子类实现更为灵活。
 * 装饰模式是一种对象结构型模式。
 * 装饰模式是一种用于替代继承的技术，它通过一种无须定义子类的方式来给对象动态增加职责，使用对象之间的关联关系取代类之间的继承关系。
 * 在装饰模式中引入了装饰类，在装饰类中既可以调用待装饰的原有类的方法，还可以增加新的方法，以扩充原有类的功能。
 */

/**
 * 在装饰模式结构图中包含如下几个角色：
 * ● Component（抽象构件）：它是具体构件和抽象装饰类的共同父类，声明了在具体构件中实现的业务方法，
 * 它的引入可以使客户端以一致的方式处理未被装饰的对象以及装饰之后的对象，实现客户端的透明操作。
 * ● ConcreteComponent（具体构件）：它是抽象构件类的子类，用于定义具体的构件对象，实现了在抽象构件中声明的方法，
 * 装饰器可以给它增加额外的职责（方法）。
 * ● Decorator（抽象装饰类）：它也是抽象构件类的子类，用于给具体构件增加职责，但是具体职责在其子类中实现。
 * 它维护一个指向抽象构件对象的引用，通过该引用可以调用装饰之前构件对象的方法，并通过其子类扩展该方法，以达到装饰的目的。
 * ● ConcreteDecorator（具体装饰类）：它是抽象装饰类的子类，负责向构件添加新的职责。
 * 每一个具体装饰类都定义了一些新的行为，它可以调用在抽象装饰类中定义的方法，并可以增加新的方法用以扩充对象的行为。
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        Component scrollBarDecorator = new ScrollBarDecorator(new Window());
        scrollBarDecorator.display();
    }
}

//抽象界面构件类：抽象构件类，为了突出与模式相关的核心代码，对原有控件代码进行了大量的简化
abstract class Component {
    public  abstract void display();
}
//窗体类：具体构件类
class Window extends Component {
    public  void display(){
        System.out.println("显示窗体！");
    }
}
//文本框类：具体构件类
class TextBox extends Component {
    public  void display() {
        System.out.println("显示文本框！");
    }
}

//构件装饰类：抽象装饰类
class ComponentDecorator extends Component {
    private Component component;  //维持对抽象构件类型对象的引用
    public ComponentDecorator(Component  component)  //注入抽象构件类型的对象
    {
        this.component = component;
    }
    public void display() {
        component.display();
    }
}
//滚动条装饰类：具体装饰类
class ScrollBarDecorator extends  ComponentDecorator {
    public ScrollBarDecorator(Component  component) {
        super(component);
    }
    public void display() {
        super.display();
        this.setScrollBar();
    }
    public  void setScrollBar() {
        System.out.println("为构件增加滚动条！");
    }
}