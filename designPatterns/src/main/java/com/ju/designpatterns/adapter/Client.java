package com.ju.designpatterns.adapter;


/**
 * 适配器模式
 * 定义:将一个类的接口转换成客户希望的另外一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作,属于结构型模式。
 * 使用场景:有动机地修改一个正常运行的系统的接口，这时应该考虑使用适配器模式。
 * 注意事项：适配器不是在详细设计时添加的，而是解决正在服役的项目的问题。
 * 优点: 1、可以让任何两个没有关联的类一起运行。 2、提高了类的复用。 3、增加了类的透明度。 4、灵活性好。
 * 缺点: 1、过多地使用适配器，会让系统非常零乱，不易整体进行把握。比如，明明看到调用的是 A 接口，其实内部被适配成了 B 接口的实现，一个系统如果太多出现这种情况，无异于一场灾难。因此如果不是很有必要，可以不使用适配器，而是直接对系统进行重构
 */
public class Client {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "xxx.pm3");
        audioPlayer.play("mp4", "xxx.mp4");
        audioPlayer.play("vlc", "xxx.vlc");
        audioPlayer.play("avi", "xxx.avi");
    }
}

