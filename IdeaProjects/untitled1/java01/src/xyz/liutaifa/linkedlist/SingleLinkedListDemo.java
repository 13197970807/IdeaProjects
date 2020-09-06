package xyz.liutaifa.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建一个链表，加入
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //测试一:
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
        //测试二:
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        //修改前显示一下
        System.out.printf("修改前的链表:\n");
        singleLinkedList.list();

        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "小尾巴");
        singleLinkedList.update(newHeroNode);
        //修改后显示一下
        System.out.printf("修改后的链表:\n");
        singleLinkedList.list();

        //删除一个节点
        singleLinkedList.del(1);
        singleLinkedList.del(3);
        System.out.printf("删除后的链表:\n");
        singleLinkedList.list();
    }
}
//定义SingleLinkedList 管理我们的英雄人物
class SingleLinkedList {
    //先初始化一个头接点，头接点不要动。
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点到单向链表
    //思路，当不考虑编号顺序的时候
    //找到链表的最后一个节点，将next指向这个新的节点
    public void add(HeroNode heroNode) {
        //因为头接点不能动，因此我们需要个辅助变量 temp
        HeroNode temp = head;
        //遍历找到最后一个节点
        while(true) {
            if(temp.next == null) {
                break;
            }
            //如果没有找到最后,就将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        temp.next = heroNode;
        //显示链表[遍历]
    }
    //第二种
    public void addByOrder(HeroNode heroNode) {
        //因为头接点不能动，
        //因为单链表，我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; //标识添加的编号是否存在，默认为false
        while (true) {
            if(temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if(temp.next.no > heroNode.no) {
                break;
            } else if(temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //
        if(flag) {
            System.out.printf("准备插入的英雄的编号%d 已经存在了，不能加入\n", heroNode.no);
        } else {
            //插入
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    //修改节点的信息，根据no编号来修改，即no编号不能改
    //说明
    //1.根据 newHeroNode 的 no 来修改即可
    public void update(HeroNode newHeroNode) {
        //判断是否空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点， 根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;
        while(true) {
            if (temp == null) {
                break; //已经遍历完链表
            }
            if(temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag 判断是否找到要修改的节点
        if(flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode);
        }
    }
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while(true) {
            if(temp.next == null) {
                break;
            }
            if(temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if(flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的%d 节点不存在\n", no);
        }
    }
    public void list() {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头接点不能动
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}

//定义HeroNode，每一个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点的域
    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方法，我们重新toString
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}

