import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManageListThree {
    public static ArrayList<PersonContact> list = new ArrayList<>();

    public static void writeFile() {
        final String PATH = "danhsach.txt";
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(PATH);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (int i = 0; i < list.size(); i++) {
                objectOutputStream.writeObject(list.get(i));
            }

        } catch (Exception e) {
        } finally {
            try {
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (Exception e) {

            }
        }

    }

    public static void readFile() {
        final String PATH = "danh sach.txt";
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(PATH);
            objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                PersonContact personContact = (PersonContact) objectInputStream.readObject();
                list.add(personContact);
            }
        } catch (Exception e) {
        } finally {
            try {
                objectInputStream.close();
                fileInputStream.close();
            } catch (Exception e) {
            }

        }
    }

    public static void showList(ArrayList<PersonContact> list) {
        for (PersonContact personContact : list) {
            System.out.println(personContact.disPlay());
        }
    }

    public static void addPerson(ArrayList<PersonContact> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Số điện thoại");
        int phone = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhóm của danh bạ");
        String group = scanner.nextLine();
        System.out.println("Họ và tên");
        String name = scanner.nextLine();
        System.out.println("Có phải nam hay không? True/false");
        boolean isMan = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Địa chỉ");
        String adress = scanner.nextLine();
        System.out.println("Ngày sinh");
        String dayOfBirth = scanner.nextLine();
        System.out.println("Email");
        String email = scanner.nextLine();
        String checkEmail = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        Pattern pattern = Pattern.compile(checkEmail);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            PersonContact personContact = new PersonContact(phone, group, name, isMan, adress, dayOfBirth, email);
            list.add(personContact);
            System.out.println("them thanh cong");
        }
    }

    public static void deletePerson(ArrayList<PersonContact> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap so dien thoai can xoa");
        int phoneNumber = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPhoneNumber() == phoneNumber) {
                System.out.println("Y/N");
                String choiceDelete= scanner.nextLine();
                if(choiceDelete=="Y"){
                    list.remove(i);
                    System.out.println("Da xoa");
                    count = 1;
                }else{
                    deletePerson(list);
                }

            }
            if (count == 0) {
                System.out.println("Khong co so dien thoai do trong danh ba");
                deletePerson(list);
            }
        }
    }

    public static void fixPerson(ArrayList<PersonContact> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap so dien thoai can cap nhat");
        int phone = scanner.nextInt();
        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPhoneNumber() == phone) {
                System.out.println("Nhóm của danh bạ");
                String group = scanner.nextLine();
                System.out.println("Họ và tên");
                String name = scanner.nextLine();
                System.out.println("Có phải nam hay không? True/false");
                boolean isMan = scanner.nextBoolean();
                scanner.nextLine();
                System.out.println("Địa chỉ");
                String adress = scanner.nextLine();
                System.out.println("Ngày sinh");
                String dayOfBirth = scanner.nextLine();
                System.out.println("Email");
                String email = scanner.nextLine();
                String checkEmail = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
                Pattern pattern = Pattern.compile(checkEmail);
                Matcher matcher = pattern.matcher(email);
                if (matcher.matches()) {
                    list.get(i).setGroup(group);
                    list.get(i).setName(name);
                    list.get(i).setMan(isMan);
                    list.get(i).setAdress(adress);
                    list.get(i).setDayOfBirth(dayOfBirth);
                    list.get(i).setEmail(email);
                    System.out.println("Da sua thanh cong");
                    count = 1;
                } else {
                    System.out.println("nhap sai dinh dang email");
                    fixPerson(list);
                }
            }
            if (count == 0) {
                System.out.println("Khong co so dien thoai trung trong danh ba ");
                fixPerson(list);
            }
        }
    }

    public static void findPerson(ArrayList<PersonContact> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so dien thoai hoac muon tim kiem");
        String name = scanner.nextLine();
        int phoneNumber = Integer.parseInt(name);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPhoneNumber() == phoneNumber||list.get(i).getName()==name) {
                System.out.println(list.get(i).disPlay());
            }
        }
    }


    public static void menu() {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("----Chương trình quản lý danh bạ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    showList(list);
                    break;
                case 2:
                    addPerson(list);
                    break;
                case 3:
                    fixPerson(list);
                    break;
                case 4:
                    deletePerson(list);
                    break;
                case 5:
                    findPerson(list);
                    break;
                case 6:
                    readFile();
                    break;
                case 7:
                    writeFile();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Chua co lua chon");
            }

        }


    }


}
