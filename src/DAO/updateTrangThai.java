package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class updateTrangThai {

    private MyConnection conn;

    public updateTrangThai() throws SQLException {
        this.conn = new MyConnection();
        conn.Connect();
    }

    public void updateExamStatus() {
        String sql = "SELECT madt, ngaythi, thoigianbatdauthi FROM dethi WHERE trangthai = 0";
        try ( PreparedStatement pre = conn.preparedStatement(sql);  ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                String examId = rs.getString(1);
                LocalDate startDate = rs.getDate(2).toLocalDate();
                LocalTime startTime = rs.getTime(3).toLocalTime();
                LocalDateTime startDateTime = LocalDateTime.of(startDate, startTime);
                LocalDateTime currentDateTime = LocalDateTime.now();
                if (currentDateTime.isAfter(startDateTime)) {
                    updateExamStatusInDatabase(examId, 1);
                    
                } else {
                    System.out.println("Trước");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateExamStatusInDatabase(String examId, int trangthai) {
        String updateQuery = "UPDATE dethi SET trangthai = ? WHERE madt = ?";
        try ( PreparedStatement pre = conn.preparedStatement(updateQuery)) {
            pre.setInt(1, trangthai);
            pre.setString(2, examId);
            int rowsAffected = pre.executeUpdate();
            if(rowsAffected>0){
                System.out.println("thanh cong");
            }else{
                System.out.println("That bai");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void updateTrangThaiDeThi() throws SQLException {
        updateTrangThai ud = new updateTrangThai();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            ud.updateExamStatus();
        }, 0, 1, TimeUnit.MINUTES);
    }
}
