package via.doc1.ex8.services;

import org.springframework.stereotype.Service;
import via.doc1.ex8.model.*;

import java.util.List;
import java.util.ArrayList;

@Service
public class TeamService {
    private static final List<TeamMember> team_members = new ArrayList<>();

    static {
        //Initialize Data
        Task t1 = new Task("Task1", "IoT Pipeline",
                "Create CD pipeline for the IoT service");
        Task t2 = new Task("Task2", "Cloud Pipeline",
                "Create CD pipeline for the backend component");
        Task t3 = new Task("Task3", "Web Pipeline",
                "Create CD pipeline for the frontend component");
        Task t4 = new Task("Task4", "DOC Doc",
                "Create the documentation for the DevOps section");

        TeamMember chase = new TeamMember(
                "Member1", "Chase", "chase@pawpatrol.org",
                new ArrayList<>(List.of(t1, t3, t4)));
        TeamMember dora = new TeamMember(
                "Member2", "Dora", "d@explorer.org",
                new ArrayList<>(List.of(t1, t2, t4)));

        team_members.add(chase);
        team_members.add(dora);
    }

    public TeamMember getTeamMember(String memberId) {
        for (TeamMember m : team_members) {
            if (m.getId().equals(memberId)) {
                return m;
            }
        }
        return null;
    }

    public List<Task> getTasks(String memberId) {
        TeamMember member = getTeamMember(memberId);
        return member == null ? null : member.getTasks();
    }

    public Task getTask(String memberId, String taskId) {
        TeamMember member = getTeamMember(memberId);

        if (member == null) {
            return null;
        }

        for (Task t : member.getTasks()) {
            if (t.getId().equals(taskId)) {
                return t;
            }
        }

        return null;

    }
}