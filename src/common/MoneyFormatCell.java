//package common;
//
//import java.text.NumberFormat;
//
//import javafx.scene.control.ListCell;
//import javafx.scene.control.TableCell;
//import javafx.scene.paint.Color;
//import members.Member;
//
//public class MoneyFormatCell extends TableCell<Member,Double> {
////    @Override
//    public void updateItem(Member item, boolean empty) {
//        super.updateItem(item.getTotalWorth(), empty);
//
//        // format the number as if it were a monetary value using the
//        // formatting relevant to the current locale. This would format
//        // 43.68 as "$43.68", and -23.67 as "($23.67)"
//        setText(item == null ? "" : NumberFormat.getCurrencyInstance().format(item));
//
//        if (item != null) {
//            double value = item.getTotalWorth();
//
//            setTextFill(value == 0 ? Color.BLACK
//                    : value < 0 ? Color.RED : Color.GREEN);
//        }
//    }
//}