package UserManagement;
import java.sql.SQLException;
import java.util.Scanner;
public class UserDriver 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		User u = new User();
		boolean control=true;
		
		while(control)
		{
			System.out.println("1.create table \n2. insert values\n3. update name \n4.delete \n5. view user By Name \n6. view all users \n7. exit");
			System.out.println("Enter your choice ????");
			Scanner sc=new Scanner(System.in);
			int choice =sc.nextInt();
			switch(choice)
			{
				case 1:
				{
					u.createTable();
					break;
				}
				case 2:
				{
					u.insertValue();
					break;
				}
				case 3:
				{
					u.updaeName();
					break;
				}
				case 4:
				{
					u.deleteUser();
					break;
				}
				case 5:
				{
					u.getUserData();
					break;
				}
				case 6:
				{
					u.getAll();
					break;
				}
				case 7:
				{
					control=false;
					System.out.println("application closed..");
					break;
				}
				default:
					System.out.println("Inalid choice");
			}
		}
		
		
	}
	
}
