package MyMenuCarService.SalseItem.ItemandCar;

import java.util.Objects;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/3 14:04
 */
public class user_car {
    public user_car(int colnum, int id, String title, float price, int num) {
        this.colnum = colnum;
        this.id = id;
        this.title = title;
        this.price = price;
        this.num = num;
    }




    public int getColnum() {
        return colnum;
    }

    public void setColnum(int colnum) {
        this.colnum = colnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        user_car user_car = (user_car) o;
        return colnum == user_car.colnum && id == user_car.id && Float.compare(user_car.price, price) == 0 && num == user_car.num && Objects.equals(title, user_car.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colnum, id, title, price, num);
    }



    @Override
    public String toString() {
        return "user_car{" +
                "colnum=" + colnum +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }



    public user_car() {
    }

    private int colnum;

    public user_car(int colnum, int id, String title, float price, int num, int user_id, String user_name) {
        this.colnum = colnum;
        this.id = id;
        this.title = title;
        this.price = price;
        this.num = num;
        this.user_id = user_id;
        this.user_name = user_name;
    }

    private int id;
    private String title;
    private float price;
    private int num;
    private int user_id;
    private String user_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }



}
