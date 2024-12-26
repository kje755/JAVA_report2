import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class ShuttleSchedule {
    private String time;
    private String bus;

    public ShuttleSchedule(String time, String bus) {
        this.time = time;
        this.bus = bus;
    }

    public String getTime() {
        return time;
    }

    public String getBus() {
        return bus;
    }
}

public class ShuttleBusSchedule extends JFrame {
    public ShuttleBusSchedule() {
        setTitle("셔틀버스 시간표");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Tab for 정문 -> 생활관
        tabbedPane.addTab("정문 -> 생활관", createTablePanel(getSchedulesToDormitory()));

        // Tab for 생활관 -> 정문
        tabbedPane.addTab("생활관 -> 정문", createTablePanel(getSchedulesToMainGate()));

        add(tabbedPane);
    }

    private JPanel createTablePanel(List<ShuttleSchedule> schedules) {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columnNames = {"시간", "버스"};
        String[][] tableData = new String[schedules.size()][2];

        for (int i = 0; i < schedules.size(); i++) {
            ShuttleSchedule schedule = schedules.get(i);
            tableData[i][0] = schedule.getTime();
            tableData[i][1] = schedule.getBus();
        }

        JTable table = new JTable(new DefaultTableModel(tableData, columnNames));
        table.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        table.setRowHeight(25);

        // 중앙 정렬을 위한 셀 렌더러 설정
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); // "시간" 열
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); // "버스" 열

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private List<ShuttleSchedule> getSchedulesToDormitory() {
        List<ShuttleSchedule> schedules = new ArrayList<>();

        String[] times = {"08:10", "08:20", "08:30", "08:40", "08:50", "09:00", "09:10", "09:20", "09:30", "09:40", "09:50", "10:00", "10:10", "10:30", "10:50", "11:10", "11:20", "11:40", "12:20", "12:50", "13:00", "13:20", "13:40", "14:20", "14:40", "15:20", "15:40", "16:20", "16:40", "17:20", "17:40"};
        String[] buses = {"학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스2", "미래로관광", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "미래로관광", "학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2"};

        for (int i = 0; i < Math.min(times.length, buses.length); i++) {
            schedules.add(new ShuttleSchedule(times[i], buses[i]));
        }

        return schedules;
    }

    private List<ShuttleSchedule> getSchedulesToMainGate() {
        List<ShuttleSchedule> schedules = new ArrayList<>();

        String[] times = {"08:10", "08:20", "08:30", "08:40", "08:50", "09:00", "09:10", "09:20", "09:30", "09:40", "09:50", "10:00", "10:10", "10:30", "10:50", "11:10", "11:20", "11:40", "12:00", "12:50", "13:00", "13:20", "13:40", "14:20", "14:40", "15:20", "15:40", "16:20", "16:40", "17:20", "17:40", "17:50"};
        String[] buses = {"학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "미래로관광", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "미래로관광", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2", "학교버스 1", "학교버스 2"};

        for (int i = 0; i < Math.min(times.length, buses.length); i++) {
            schedules.add(new ShuttleSchedule(times[i], buses[i]));
        }

        return schedules;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ShuttleBusSchedule().setVisible(true);
        });
    }
}
