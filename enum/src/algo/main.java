package algo;

import java.util.stream.Stream;

public class main
{
    private enum Button{
        BUTTON_NOT_FOUND("Not found", "The button doesn't exist"),
        BUTTON_CANCEL("cancel","//a[@data-testid = 'row-1_cancelButton']");

        private String name, xpath;
        Button(String name, String xpath) {
            this.name = name;
            this.xpath=xpath;
        }
        private String getXpath(){
            return this.xpath;
        }
        private String getName(){
            return this.name;
        }
        static private String getXpathByButtonName(String name){
            return Stream.of(Button.values())
                    .filter(x->x.getName().equals(name))
                    .findFirst()
                    .orElse(BUTTON_NOT_FOUND)
                    .getXpath();

//            for(Button button: Button.values()){
//                if(button.getName().equals(name))
//                    return button;
//            }
//            return null;
        }
    }
    public static void main(String[] args) {
        System.out.println(Button.getXpathByButtonName("cancel"));
    }
}
