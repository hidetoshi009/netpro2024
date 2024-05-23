public class DinnerFullCourse {
    private Dish[] list = new Dish[5];// [0]-[4]の計5個

	public static void main(String[] args) {

		DinnerFullCourse fullcourse = new DinnerFullCourse();
		fullcourse.eatAll();
    }
    DinnerFullCourse() {
        for(int i=0;i<5;i++){
            list[i] = new Dish();
        }
		list[0].setName("特選シーザサラダ");
		list[0].setValune(10);

		list[1].setName("銀しゃり");
		list[1].setValune(2);
		
		list[2].setName("梅干し");
		list[2].setValune(20);

        list[3].setName("ステーキ");
		list[3].setValune(200);
		
		list[4].setName("プリン");
		list[4].setValune(100);


	}

        void eatAll() {
            System.out.println("フルコースは");
            for(Dish dish:list){
            System.err.println(dish.getName() + dish.getValune() + "円");
        }
            System.out.println("です");
        }

}
