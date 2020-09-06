package linkdlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        System.out.println("双向链表的测试");
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        //修改
        HeroNode newHeroNode = new HeroNode(4, "sam_liu", "泰迪熊");
        doubleLinkedList.update(newHeroNode);
        System.out.println("这是修改过后的双向链表");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.del(1);
        doubleLinkedList.del(2);
        System.out.println("这是删除后的双向链表");
        doubleLinkedList.list();
    }
}

//创建一个双向链表的类
class DoubleLinkedList {
    //先初始化一个头接点，头接点不要动。
    private HeroNode head = new HeroNode(0, "", "");

    //返回头接点
    public HeroNode getHead() {
        return head;
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

    //添加一个节点到双向链表到最后
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
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
        //显示链表[遍历]
    }

    //可以看到双向链表的节点内容修改和单向链表一样
    //只是节点类型
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

    //从双向链表中删除一个个节点
    //对于双向链表直接找到要删除的节点
    public void del(int no) {

        //判断当前节点是否为空
        if(head.next == null) {
            System.out.println("双向链表为空");
            return;
        }

        HeroNode temp = head.next; //这是一个辅助指针（或辅助变量）
        boolean flag = false; //标志是否找到了待删除的节点
        while(true) {
            if(temp == null) {
                break;
            }
            if(temp.no == no) {//已经找到链表的最后节点的next
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if(flag) {
            temp.pre.next = temp.next;
            //这里的代码有问题,如最后一个节点就不要执行下面这句代码，否则会出现空指针异常
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的%d 节点不存在\n", no);
        }
    }
}


//定义HeroNode，每一个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点的域
    public HeroNode pre; //指向上一个节点的域
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