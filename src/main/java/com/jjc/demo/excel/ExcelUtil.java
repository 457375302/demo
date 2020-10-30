package com.jjc.demo.excel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class ExcelUtil {

    //导入去除一些空数据行
    private static boolean isParamNull(Map<String, Object> map){
        AtomicBoolean isTrue = new AtomicBoolean(false);
        map.entrySet().forEach(item -> {
            if(isTrue.get()){
                return;
            }
            isTrue.set(!item.getKey().equals("备注") &&item.getValue()==null);
        });
        return  isTrue.get();
    }

/*    public static void main(String[] args) throws Exception {
        File file = new File("D:\\ex2020-06-12-15-35-06.xlsx");
        FileInputStream fis = new FileInputStream(file);
        List<Map> maps = ReaderExcelUtils.ReaderExcel(fis, file.getName());
        for (Map<String, Object> mapdata : maps) {
          mapdata.put("id", mapdata.remove("订单id"));
                mapdata.put("orderNo", mapdata.remove("订单编号"));
                mapdata.put("companyName", mapdata.remove("物流公司名称"));
                mapdata.put("companyIden", mapdata.remove("物流公司类型"));
                mapdata.put("logisticsNumber", mapdata.remove("物流编号"));
                mapdata.remove("ex1SheetNumber");
                mapdata.remove("sheetNameex1");
            }
        maps.remove( maps.get(maps.size()-1));
        List<Map> newMaps = new ArrayList<>();
        maps.forEach(map -> {
            if(!isParamNull(map)){
                newMaps.add(map);
            }
        });
        System.out.println(newMaps);
    }*/


}
