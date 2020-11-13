package ch06.sec07;

import java.util.ArrayList;
import java.util.List;

public  class  WildCardPECS <T extends Number, V>  {
    private T tValue;
    private V vValue;
    public  <K> K  getValue(K key){
        //добавляемое значение должно принадлежать всем типам наследникам
//        это может null
        List<? extends Number> list1 = new ArrayList<>();
//        list.add(1L);
        //получаемое значение должно быть любого типа предка  - Object
        List<? super Integer> list2 = new ArrayList<>();
        list2.add(1);
//        Number number = list2.get(0);
        return key;
    }
}
