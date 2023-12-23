package com.example.syllabusmanager;
import java.io.File;
import java.sql.*;

public class DBConnector {
    private static DBConnector instance = null;

    private final String fileName;
    private Connection connection;

    private PreparedStatement insertCourseMainTable, insertCourseInformationTable, insertCourseAssessmentTable,
            insertCourseWeeklySchedule, insertCourseWorkloadTable;

    DBConnector() {
        this.fileName = "versionsDatabase.db";
        File file = new File(fileName);
        boolean firstRun = !file.exists();

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + fileName);

            if (firstRun) {
                // Define SQL statements as constants
                final String CREATE_COURSE_MAIN_TABLE = "CREATE TABLE IF NOT EXISTS CourseMainTable (" +
                        "\"version\" INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "\"changeDate\" TEXT," +
                        "\"changeReason\" TEXT," +
                        "\"Course_id\" TEXT," +
                        "\"Course_WeeklySchedule_id\" TEXT," +
                        "\"Course_AssestmentTable_id\" INTEGER," +
                        "\"Course_EctsTable_id\" INTEGER," +
                        "\"Course_OutcomeTable_id\" INTEGER)";

                final String CREATE_COURSE_INFORMATION_TABLE = "CREATE TABLE IF NOT EXISTS CourseInformationTable (" +
                        "\"version\" INTEGER PRIMARY KEY," +
                        "\"Course_id\" TEXT," +
                        "\"Theory\" TEXT," +
                        "\"Lab\" TEXT," +
                        "\"Information_id\" INTEGER," +
                        "\"courseName\" TEXT," +
                        "\"codeFallSpringTheory\" INTEGER," +
                        "\"application\" TEXT," +
                        "\"localCredits\" INTEGER," +
                        "\"ects\" TEXT," +
                        "\"prerequisites\" TEXT," +
                        "\"courseLanguage\" INTEGER," +
                        "\"courseType\" INTEGER," +
                        "\"courseLevel\" INTEGER," +
                        "\"modeOfDelivery\" INTEGER," +
                        "\"teachingMethodsAndTechniques\" TEXT," +
                        "\"courseCoordinator\" TEXT," +
                        "\"courseLecturers\" TEXT," +
                        "\"assistants\" TEXT," +
                        "\"courseObjectives\" TEXT," +
                        "\"learningOutcomes\" TEXT," +
                        "\"courseDescription\" TEXT," +
                        "\"courseCategory\" INTEGER)";

                final String CREATE_ASSESSMENT_TABLE = "CREATE TABLE IF NOT EXISTS CourseAssessmentTable (" +
                        "\"version\" INTEGER PRIMARY KEY," +
                        "\"assessment_id\" INTEGER," +
                        "\"assesParticipN\" INTEGER," +
                        "\"assesParticipW\" INTEGER," +
                        "\"assesParticipLO\" INTEGER," +
                        "\"assesLabN\" INTEGER," +
                        "\"assesLabW\" INTEGER," +
                        "\"assesLabLO\" INTEGER," +
                        "\"assesFiledN\" INTEGER," +
                        "\"assesFiledW\" INTEGER," +
                        "\"assesFiledLO\" INTEGER," +
                        "\"assesQuizN\" INTEGER," +
                        "\"assesQuizW\" INTEGER," +
                        "\"assesQuizLO\" INTEGER," +
                        "\"assesHomewN\" INTEGER," +
                        "\"assesHomewW\" INTEGER," +
                        "\"assesHomewLO\" INTEGER," +
                        "\"assesPresentN\" INTEGER," +
                        "\"assesPresentW\" INTEGER," +
                        "\"assesPresentLO\" INTEGER," +
                        "\"assesProjectN\" INTEGER," +
                        "\"assesProjectW\" INTEGER," +
                        "\"assesProjectLO\" INTEGER," +
                        "\"assesPortfolN\" INTEGER," +
                        "\"assesPortfolW\" INTEGER," +
                        "\"assesPortfolLO\" INTEGER," +
                        "\"assesWorkshN\" INTEGER," +
                        "\"assesWorkshW\" INTEGER," +
                        "\"assesWorkshLO\" INTEGER," +
                        "\"assesOraleN\" INTEGER," +
                        "\"assesOraleW\" INTEGER," +
                        "\"assesOraleLO\" INTEGER," +
                        "\"assesMidtN\" INTEGER," +
                        "\"assesMidtW\" INTEGER," +
                        "\"assesMidtLO\" INTEGER," +
                        "\"assesFinalN\" INTEGER," +
                        "\"assesFinalW\" INTEGER," +
                        "\"assesFinalLO\" INTEGER," +
                        "\"assesWeightofSemesterN\" INTEGER," +
                        "\"assesWeightofSemesterW\" INTEGER," +
                        "\"assesWeightofSemesterLO\" INTEGER," +
                        "\"assesWeightofEndofSemesterN\" INTEGER," +
                        "\"assesWeightofEndofSemesterW\" INTEGER," +
                        "\"assesWeightofEndofSemesterLO\" INTEGER)";


                final String CREATE_WORKLOAD_TABLE = "CREATE TABLE IF NOT EXISTS CourseWorkloadTable (" +
                        "\"version\" INTEGER PRIMARY KEY," +
                        "\"workload_id\" INTEGER," +
                        "\"ectsCoursehourN\" INTEGER," +
                        "\"ectsCoursehourDH\" INTEGER," +
                        "\"ectsCoursehourW\" INTEGER," +
                        "\"ectsLabhourN\" INTEGER," +
                        "\"ectsLabhourDH\" INTEGER," +
                        "\"ectsLabhourW\" INTEGER" +
                        "\"ectsStudyhourN\" INTEGER," +
                        "\"ectsStudyhourDH\" INTEGER," +
                        "\"ectsStudyhourW\" INTEGER" +
                        "\"ectsFieldworkN\" INTEGER," +
                        "\"ectsFieldworkDH\" INTEGER," +
                        "\"ectsFieldworkW\" INTEGER" +
                        "\"ectsQuizN\" INTEGER," +
                        "\"ectsQuizH\" INTEGER," +
                        "\"ectsQuizW\" INTEGER" +
                        "\"ectsHomeworkN\" INTEGER," +
                        "\"ectsHomeworkH\" INTEGER," +
                        "\"ectsHomeworkW\" INTEGER" +
                        "\"ectsPresentationN\" INTEGER," +
                        "\"ectsPresentationH\" INTEGER," +
                        "\"ectsPresentationW\" INTEGER" +
                        "\"ectsProjectN\" INTEGER," +
                        "\"ectsProjectH\" INTEGER," +
                        "\"ectsProjectW\" INTEGER" +
                        "\"ectsPortfolioN\" INTEGER," +
                        "\"ectsPortfolioH\" INTEGER," +
                        "\"ectsPortfolioW\" INTEGER" +
                        "\"ectsWorkshopN\" INTEGER," +
                        "\"ectsWorkshopH\" INTEGER," +
                        "\"ectsWorkshopW\" INTEGER" +
                        "\"ectsOralexamN\" INTEGER," +
                        "\"ectsOralexamH\" INTEGER," +
                        "\"ectsOralexamW\" INTEGER" +
                        "\"ectsMidtermN\" INTEGER," +
                        "\"ectsMidtermH\" INTEGER," +
                        "\"ectsMidtermW\" INTEGER" +
                        "\"ectsFinalN\" INTEGER," +
                        "\"ectsFinalH\" INTEGER," +
                        "\"ectsFinalW\" INTEGER)";


                final String CREATE_COURSE_WEEKLY_SCHEDULE_TABLE = "CREATE TABLE IF NOT EXISTS CourseWeeklySchedule (" +
                        "\"version\" INTEGER PRIMARY KEY," +
                        "\"schedule_id\" INTEGER," +
                        "\"weeklysub_1sub\" TEXT," +
                        "\"weeklysub_1req\" TEXT," +
                        "\"weeklysub_2sub\" TEXT," +
                        "\"weeklysub_2req\" TEXT," +
                        "\"weeklysub_3sub\" TEXT," +
                        "\"weeklysub_3req\" TEXT," +
                        "\"weeklysub_4sub\" TEXT," +
                        "\"weeklysub_4req\" TEXT," +
                        "\"weeklysub_5sub\" TEXT," +
                        "\"weeklysub_5req\" TEXT," +
                        "\"weeklysub_6sub\" TEXT," +
                        "\"weeklysub_6req\" TEXT," +
                        "\"weeklysub_7sub\" TEXT," +
                        "\"weeklysub_7req\" TEXT," +
                        "\"weeklysub_8sub\" TEXT," +
                        "\"weeklysub_8req\" TEXT," +
                        "\"weeklysub_9sub\" TEXT," +
                        "\"weeklysub_9req\" TEXT," +
                        "\"weeklysub_10sub\" TEXT," +
                        "\"weeklysub_10req\" TEXT," +
                        "\"weeklysub_11sub\" TEXT," +
                        "\"weeklysub_11req\" TEXT," +
                        "\"weeklysub_12sub\" TEXT," +
                        "\"weeklysub_12req\" TEXT," +
                        "\"weeklysub_13sub\" TEXT," +
                        "\"weeklysub_13req\" TEXT," +
                        "\"weeklysub_14sub\" TEXT," +
                        "\"weeklysub_14req\" TEXT," +
                        "\"weeklysub_15sub\" TEXT," +
                        "\"weeklysub_15req\" TEXT," +
                        "\"weeklysub_16sub\" TEXT," +
                        "\"weeklysub_16req\" TEXT," +
                        "\"weeklysub_coursenotes\" TEXT," +
                        "\"weeklysub_suggmat\" TEXT)";

                final String CREATE_COURSE_OUTCOME_TABLE = "CREATE TABLE IF NOT EXISTS CourseOutcomeTable (" +
                        "\"version\" INTEGER PRIMARY KEY," +
                        "\"lo\" TEXT," +
                        "\"outcome\" TEXT," +
                        "\"contributionLevel\" INTEGER)";

                Statement stmt = connection.createStatement();
                stmt.executeUpdate(CREATE_COURSE_MAIN_TABLE);

                stmt.executeUpdate(CREATE_COURSE_INFORMATION_TABLE);
                stmt.executeUpdate(CREATE_COURSE_WEEKLY_SCHEDULE_TABLE);
                stmt.executeUpdate(CREATE_ASSESSMENT_TABLE);
                stmt.executeUpdate(CREATE_WORKLOAD_TABLE);
                stmt.executeUpdate(CREATE_COURSE_OUTCOME_TABLE);
            }

            /*insertCourseMainTable = connection.prepareStatement("INSERT INTO CourseMainTable (changeDate,changeReason,Course_id,Course_WeeklySchedule_id,Course_AssestmentTable_id,Course_EctsTable_id,Course_OutcomeTable_id) VALUES (?,?,?,?,?,?,?)");
            insertCourseInformationTable = connection.prepareStatement("INSERT INTO CourseInformationTable (Course_id, Information_id, courseName, codeFallSpringTheory, application, localCredits, ects, prerequisites, courseLanguage, courseType, courseLevel, modeOfDelivery, teachingMethodsAndTechniques, courseCoordinator, courseLecturers, assistants, courseObjectives, learningOutcomes, courseDescription, courseCategory, Theory, Lab,version) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)");
            insertCourseAssessmentTable = connection.prepareStatement("INSERT INTO CourseAssessmentTable (assessment_id,assesParticipN,assesParticipW,assesParticipLO,assesLabN,assesLabW,assesLabLO,assesFiledN,assesFiledW,assesFiledLO,assesQuizN,assesQuizW,assesQuizLO,assesHomewN,assesHomewW,assesHomewLO,assesPresentN,assesPresentW,assesPresentLO,assesProjectN,assesProjectW,assesProjectLO,assesPortfolN,assesPortfolW,assesPortfolLO,assesWorkshN,assesWorkshW,assesWorkshLO,assesOraleN,assesOraleW,assesOraleLO,assesMidtN,assesMidtW,assesMidtLO,assesFinalN,assesFinalW,assesFinalLO,assesWeightofSemesterN,assesWeightofSemesterW,assesWeightofSemesterLO,assesWeightofEndofSemesterN,assesWeightofEndofSemesterW,assesWeightofEndofSemesterLO,version) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            insertCourseWorkloadTable = connection.prepareStatement("INSERT INTO CourseWorkloadTable (workload_id,ectsCoursehourN, ectsCoursehourDH, ectsCoursehourW,ectsLabhourN, ectsLabhourDH, ectsLabhourW,ectsStudyhourN, ectsStudyhourDH, ectsStudyhourW,ectsFieldworkN, ectsFieldworkDH, ectsFieldworkW,ectsQuizN, ectsQuizDH, ectsQuizW,ectsHomeworkN, ectsHomeworkDH, ectsHomeworkW,ectsPresentationN, ectsPresentationDH, ectsPresentationW,ectsProjectN, ectsProjectDH, ectsProjectW,ectsPortfolioN, ectsPortfolioDH, ectsPortfolioW,ectsWorkshopN, ectsWorkshopDH, ectsWorkshopW,ectsOralexamN, ectsOralexamDH, ectsOralexamW,ectsMidtermN, ectsMidtermDH, ectsMidtermW,ectsFinalN, ectsFinalDH, ectsFinalW,version) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            insertCourseWeeklySchedule = connection.prepareStatement("INSERT INTO CourseWeeklySchedule (schedule_id,weeklysub_1sub, weeklysub_1req,weeklysub_2sub, weeklysub_2req,weeklysub_3sub, weeklysub_3req,weeklysub_4sub, weeklysub_4req,weeklysub_5sub, weeklysub_5req,weeklysub_6sub, weeklysub_6req,weeklysub_7sub, weeklysub_7req,weeklysub_8sub, weeklysub_8req,weeklysub_9sub, weeklysub_9req,weeklysub_10sub, weeklysub_10req,weeklysub_11sub, weeklysub_11req,weeklysub_12sub, weeklysub_12req,weeklysub_13sub, weeklysub_13req,weeklysub_14sub, weeklysub_14req,weeklysub_15sub, weeklysub_15req,weeklysub_16sub, weeklysub_16req,weeklysub_coursenotes, weeklysub_suggmat,version) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)");
            */

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    public static DBConnector getInstance() {
        if (instance == null) {
            instance = new DBConnector();
        }
        return instance;
    }

    public int addCourseMainTable(Syllabus syllabus) {
        try {

            PreparedStatement insertCourseMainTable = connection.prepareStatement("INSERT INTO CourseMainTable (changeDate,changeReason,Course_id,Course_WeeklySchedule_id,Course_AssestmentTable_id,Course_EctsTable_id,Course_OutcomeTable_id) VALUES (?,?,?,?,?,?,?)");

            String changeDate = null;
            String changeReason = null;
            String course_id = syllabus.GI_code;
            String courseWeeklyScheduleId = null;
            int courseAssessmentTableId = 0;
            int courseEctsTableId = 0;
            int courseOutcomeTableId = 0;


            insertCourseMainTable.setString(1, changeDate);
            insertCourseMainTable.setString(2, changeReason);
            insertCourseMainTable.setString(3, course_id);
            insertCourseMainTable.setString(4, courseWeeklyScheduleId);
            insertCourseMainTable.setInt(5, courseAssessmentTableId);
            insertCourseMainTable.setInt(6, courseEctsTableId);
            insertCourseMainTable.setInt(7, courseOutcomeTableId);


            insertCourseMainTable.execute();

            ResultSet generatedKeys = insertCourseMainTable.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                System.out.println("Generated ID: " + generatedId);

                return generatedId;
            } else {
                System.out.println("No ID generated for the inserted row.");

                return -1;
            }

        } catch (Exception e) {
            System.err.println(e);
        }

        return 0;
    }

    public void addCourseInformationTable(Syllabus syllabus) {
        try {

            String course_id = null;
            int information_id = 0;
            String courseName = syllabus.GI_code;
            int codeFallSpringTheory = syllabus.GI_call_spring;
            String application = null;
            String Lab=syllabus.GI_lab;
            String Theory=syllabus.GI_theory;
            int localCredits = syllabus.GIl_ocalcredit;
            String ects = null;
            String prerequisites = syllabus.GI_prequisities;
            int courseLanguage = syllabus.GI_language;
            int courseType = syllabus.GI_type;
            int courseLevel = syllabus.GI_level;
            int modeOfDelivery = syllabus.GI_modeofdelivery;
            String teachingMethodsAndTechniques = syllabus.GI_teachingmethods;
            String courseCoordinator = syllabus.GI_coordinator;
            String courseLecturers = syllabus.GI_lecturer;
            String assistants = syllabus.GI_assistant;
            String courseObjectives = syllabus.GI_objectives;
            String learningOutcomes = syllabus.GI_learningoutcomes;
            int courseCategory = syllabus.GI_coursecategory;

            PreparedStatement insertCourseInformationTable = connection.prepareStatement("INSERT INTO CourseInformationTable (Course_id, Information_id, courseName, codeFallSpringTheory, application, localCredits, ects, prerequisites, courseLanguage, courseType, courseLevel, modeOfDelivery, teachingMethodsAndTechniques, courseCoordinator, courseLecturers, assistants, courseObjectives, learningOutcomes, courseDescription, courseCategory, Theory, Lab) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
            insertCourseInformationTable.setString(1, course_id);
            insertCourseInformationTable.setInt(2, information_id);
            insertCourseInformationTable.setString(3, courseName);
            insertCourseInformationTable.setInt(4, codeFallSpringTheory);
            insertCourseInformationTable.setString(5, application);
            insertCourseInformationTable.setInt(6, localCredits);
            insertCourseInformationTable.setString(7, ects);
            insertCourseInformationTable.setString(8, prerequisites);
            insertCourseInformationTable.setInt(9, courseLanguage);
            insertCourseInformationTable.setInt(10, courseType);
            insertCourseInformationTable.setInt(11, courseLevel);
            insertCourseInformationTable.setInt(12, modeOfDelivery);
            insertCourseInformationTable.setString(13, teachingMethodsAndTechniques);
            insertCourseInformationTable.setString(14, courseCoordinator);
            insertCourseInformationTable.setString(15, courseLecturers);
            insertCourseInformationTable.setString(16, assistants);
            insertCourseInformationTable.setString(17, courseObjectives);
            insertCourseInformationTable.setString(18, learningOutcomes);
            insertCourseInformationTable.setInt(20, courseCategory);
            insertCourseInformationTable.setString(21, Theory);
            insertCourseInformationTable.setString(22, Lab);


            insertCourseInformationTable.execute();


        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public void addCourseAssessmentTable(Syllabus syllabus) {
        try {
            int assessment_id ;
            int assesParticipN = syllabus.AssesParticip_N;
            int assesParticipW = syllabus.AssesParticip_W;
            int assesParticipLO = syllabus.AssesParticip_LO;
            int assesLabN = syllabus.AssesLab_N;
            int assesLabW = syllabus.AssesLab_W;
            int assesLabLO = syllabus.AssesLab_LO;
            int assesFiledN = syllabus.AssesFieldwork_N;
            int assesFiledW = syllabus.AssesFieldwork_W;
            int assesFiledLO = syllabus.AssesFieldwork_LO;
            int assesQuizN = syllabus.AssesQuiz_N;
            int assesQuizW = syllabus.AssesQuiz_W;
            int assesQuizLO = syllabus.AssesQuiz_LO;
            int assesHomewN = syllabus.AssesHomework_N;
            int assesHomewW = syllabus.AssesHomework_W;
            int assesHomewLO = syllabus.AssesHomework_LO;
            int assesPresentN = syllabus.AssesPresentation_N;
            int assesPresentW = syllabus.AssesPresentation_W;
            int assesPresentLO = syllabus.AssesPresentation_LO;
            int assesProjectN = syllabus.AssesProject_N;
            int assesProjectW = syllabus.AssesProject_W;
            int assesProjectLO = syllabus.AssesProject_LO;
            int assesPortfolN = syllabus.AssesPortfolio_N;
            int assesPortfolW = syllabus.AssesPortfolio_W;
            int assesPortfolLO = syllabus.AssesPortfolio_LO;
            int assesWorkshN = syllabus.AssesSeminar_N;
            int assesWorkshW = syllabus.AssesSeminar_W;
            int assesWorkshLO = syllabus.AssesSeminar_LO;
            int assesOraleN = syllabus.AssesOralexam_N;
            int assesOraleW = syllabus.AssesOralexam_W;
            int assesOraleLO = syllabus.AssesOralexam_LO;
            int assesMidtN = syllabus.AssesMidterm_N;
            int assesMidtW = syllabus.AssesMidterm_W;
            int assesMidtLO = syllabus.AssesMidterm_LO;
            int assesFinalN = syllabus.AssesFinal_N;
            int assesFinalW = syllabus.AssesFinal_W;
            int assesFinalLO = syllabus.AssesFinal_LO;
            int assesWeightofSemesterN = syllabus.AssesWeightingofSemesterActivitiesontheFinalGrade_N;
            int assesWeightofSemesterW =syllabus.AssesWeightingofSemesterActivitiesontheFinalGrade_W;
            int assesWeightofSemesterLO = syllabus.AssesWeightingofSemesterActivitiesontheFinalGrade_LO;
            int assesWeightofEndofSemesterN = syllabus.AssesWeightingofEndofSemesterActivitiesontheFinalGrade_N;
            int assesWeightofEndofSemesterW = syllabus.AssesWeightingofEndofSemesterActivitiesontheFinalGrade_W;
            int assesWeightofEndofSemesterLO = syllabus.AssesWeightingofEndofSemesterActivitiesontheFinalGrade_LO;

            PreparedStatement insertCourseAssessmentTable = connection.prepareStatement("INSERT INTO CourseAssessmentTable (assessment_id,assesParticipN,assesParticipW,assesParticipLO,assesLabN,assesLabW,assesLabLO,assesFiledN,assesFiledW,assesFiledLO,assesQuizN,assesQuizW,assesQuizLO,assesHomewN,assesHomewW,assesHomewLO,assesPresentN,assesPresentW,assesPresentLO,assesProjectN,assesProjectW,assesProjectLO,assesPortfolN,assesPortfolW,assesPortfolLO,assesWorkshN,assesWorkshW,assesWorkshLO,assesOraleN,assesOraleW,assesOraleLO,assesMidtN,assesMidtW,assesMidtLO,assesFinalN,assesFinalW,assesFinalLO,assesWeightofSemesterN,assesWeightofSemesterW,assesWeightofSemesterLO,assesWeightofEndofSemesterN,assesWeightofEndofSemesterW,assesWeightofEndofSemesterLO) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            //insertCourseAssessmentTable.setInt(1, assessment_id); probabaly will not be used
            insertCourseAssessmentTable.setInt(2, assesParticipN);
            insertCourseAssessmentTable.setInt(3, assesParticipW);
            insertCourseAssessmentTable.setInt(4, assesParticipLO);
            insertCourseAssessmentTable.setInt(5, assesLabN);
            insertCourseAssessmentTable.setInt(6, assesLabW);
            insertCourseAssessmentTable.setInt(7, assesLabLO);
            insertCourseAssessmentTable.setInt(8, assesFiledN);
            insertCourseAssessmentTable.setInt(9, assesFiledW);
            insertCourseAssessmentTable.setInt(10, assesFiledLO);
            insertCourseAssessmentTable.setInt(11, assesQuizN);
            insertCourseAssessmentTable.setInt(12, assesQuizW);
            insertCourseAssessmentTable.setInt(13, assesQuizLO);
            insertCourseAssessmentTable.setInt(14, assesHomewN);
            insertCourseAssessmentTable.setInt(15, assesHomewW);
            insertCourseAssessmentTable.setInt(16, assesHomewLO);
            insertCourseAssessmentTable.setInt(17, assesPresentN);
            insertCourseAssessmentTable.setInt(18, assesPresentW);
            insertCourseAssessmentTable.setInt(19, assesPresentLO);
            insertCourseAssessmentTable.setInt(20, assesProjectN);
            insertCourseAssessmentTable.setInt(21, assesProjectW);
            insertCourseAssessmentTable.setInt(22, assesProjectLO);
            insertCourseAssessmentTable.setInt(23, assesPortfolN);
            insertCourseAssessmentTable.setInt(24, assesPortfolW);
            insertCourseAssessmentTable.setInt(25, assesPortfolLO);
            insertCourseAssessmentTable.setInt(26, assesWorkshN);
            insertCourseAssessmentTable.setInt(27, assesWorkshW);
            insertCourseAssessmentTable.setInt(28, assesWorkshLO);
            insertCourseAssessmentTable.setInt(29, assesOraleN);
            insertCourseAssessmentTable.setInt(30, assesOraleW);
            insertCourseAssessmentTable.setInt(31, assesOraleLO);
            insertCourseAssessmentTable.setInt(32, assesMidtN);
            insertCourseAssessmentTable.setInt(33, assesMidtW);
            insertCourseAssessmentTable.setInt(34, assesMidtLO);
            insertCourseAssessmentTable.setInt(35, assesFinalN);
            insertCourseAssessmentTable.setInt(36, assesFinalW);
            insertCourseAssessmentTable.setInt(37, assesFinalLO);
            insertCourseAssessmentTable.setInt(38, assesWeightofSemesterN);
            insertCourseAssessmentTable.setInt(39, assesWeightofSemesterW);
            insertCourseAssessmentTable.setInt(40, assesWeightofSemesterLO);
            insertCourseAssessmentTable.setInt(41, assesWeightofEndofSemesterN);
            insertCourseAssessmentTable.setInt(42, assesWeightofEndofSemesterW);
            insertCourseAssessmentTable.setInt(43, assesWeightofEndofSemesterLO);

            insertCourseAssessmentTable.execute();


        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public void addCourseWorkloadTable(Syllabus syllabus) {
        try {
            int workload_id;
            int ectsCoursehourN = syllabus.WLTableCoursehours_N;
            int ectsCoursehourDH = syllabus.WLTableCoursehours_DH;
            int ectsCoursehourW = syllabus.WLTableCoursehours_W;
            int ectsLabhourN = syllabus.WLTableLabhours_N;
            int ectsLabhourDH = syllabus.WLTableLabhours_DH;
            int ectsLabhourW = syllabus.WLTableLabhours_W;
            int ectsStudyhourN = syllabus.WLTableStudyhoursoutofclass_N;
            int ectsStudyhourDH = syllabus.WLTableStudyhoursoutofclass_DH;
            int ectsStudyhourW = syllabus.WLTableStudyhoursoutofclass_W;
            int ectsFieldworkN = syllabus.WLTableFieldwork_N;
            int ectsFieldworkDH = syllabus.WLTableFieldwork_DH;
            int ectsFieldworkW = syllabus.WLTableFieldwork_W;
            int ectsQuizN = syllabus.WLTableQuiz_N;
            int ectsQuizDH = syllabus.WLTableQuiz_DH;
            int ectsQuizW = syllabus.WLTableQuiz_W;
            int ectsHomeworkN = syllabus.WLTableHomework_N;
            int ectsHomeworkDH = syllabus.WLTableHomework_DH;
            int ectsHomeworkW = syllabus.WLTableHomework_W;
            int ectsPresentationN = syllabus.WLTablePresentation_N;
            int ectsPresentationDH = syllabus.WLTablePresentation_DH;
            int ectsPresentationW = syllabus.WLTablePresentation_W;
            int ectsProjectN = syllabus.WLTableProject_N;
            int ectsProjectDH = syllabus.WLTableProject_DH;
            int ectsProjectW = syllabus.WLTableProject_W;
            int ectsPortfolioN = syllabus.WLTablePortfolio_N;
            int ectsPortfolioDH = syllabus.WLTablePortfolio_DH;
            int ectsPortfolioW = syllabus.WLTablePortfolio_W;
            int ectsWorkshopN = syllabus.WLTableSeminar_N;
            int ectsWorkshopDH = syllabus.WLTableSeminar_DH;
            int ectsWorkshopW = syllabus.WLTableSeminar_W;
            int ectsOralexamN = syllabus.WLTableOralexam_N;
            int ectsOralexamDH = syllabus.WLTableOralexam_DH;
            int ectsOralexamW = syllabus.WLTableOralexam_W;
            int ectsMidtermN = syllabus.WLTableMidterm_N;
            int ectsMidtermDH = syllabus.WLTableMidterm_DH;
            int ectsMidtermW = syllabus.WLTableMidterm_W;
            int ectsFinalN = syllabus.WLTableFinal_N;
            int ectsFinalDH = syllabus.WLTableFinal_DH;
            int ectsFinalW = syllabus.WLTableFinal_W;

            PreparedStatement insertCourseWorkloadTable = connection.prepareStatement("INSERT INTO CourseWorkloadTable (workload_id,ectsCoursehourN, ectsCoursehourDH, ectsCoursehourW,ectsLabhourN, ectsLabhourDH, ectsLabhourW,ectsStudyhourN, ectsStudyhourDH, ectsStudyhourW,ectsFieldworkN, ectsFieldworkDH, ectsFieldworkW,ectsQuizN, ectsQuizDH, ectsQuizW,ectsHomeworkN, ectsHomeworkDH, ectsHomeworkW,ectsPresentationN, ectsPresentationDH, ectsPresentationW,ectsProjectN, ectsProjectDH, ectsProjectW,ectsPortfolioN, ectsPortfolioDH, ectsPortfolioW,ectsWorkshopN, ectsWorkshopDH, ectsWorkshopW,ectsOralexamN, ectsOralexamDH, ectsOralexamW,ectsMidtermN, ectsMidtermDH, ectsMidtermW,ectsFinalN, ectsFinalDH, ectsFinalW) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            /*insertCourseWorkloadTable.setInt(1, workload_id);*/
            insertCourseWorkloadTable.setInt(2, ectsCoursehourN);
            insertCourseWorkloadTable.setInt(3, ectsCoursehourDH);
            insertCourseWorkloadTable.setInt(4, ectsCoursehourW);
            insertCourseWorkloadTable.setInt(5, ectsLabhourN);
            insertCourseWorkloadTable.setInt(6, ectsLabhourDH);
            insertCourseWorkloadTable.setInt(7, ectsLabhourW);
            insertCourseWorkloadTable.setInt(8, ectsStudyhourN);
            insertCourseWorkloadTable.setInt(9, ectsStudyhourDH);
            insertCourseWorkloadTable.setInt(10, ectsStudyhourW);
            insertCourseWorkloadTable.setInt(11, ectsFieldworkN);
            insertCourseWorkloadTable.setInt(12, ectsFieldworkDH);
            insertCourseWorkloadTable.setInt(13, ectsFieldworkW);
            insertCourseWorkloadTable.setInt(14, ectsQuizN);
            insertCourseWorkloadTable.setInt(15, ectsQuizDH);
            insertCourseWorkloadTable.setInt(16, ectsQuizW);
            insertCourseWorkloadTable.setInt(17, ectsHomeworkN);
            insertCourseWorkloadTable.setInt(18, ectsHomeworkDH);
            insertCourseWorkloadTable.setInt(19, ectsHomeworkW);
            insertCourseWorkloadTable.setInt(20, ectsPresentationN);
            insertCourseWorkloadTable.setInt(21, ectsPresentationDH);
            insertCourseWorkloadTable.setInt(22, ectsPresentationW);
            insertCourseWorkloadTable.setInt(23, ectsProjectN);
            insertCourseWorkloadTable.setInt(24, ectsProjectDH);
            insertCourseWorkloadTable.setInt(25, ectsProjectW);
            insertCourseWorkloadTable.setInt(26, ectsPortfolioN);
            insertCourseWorkloadTable.setInt(27, ectsPortfolioDH);
            insertCourseWorkloadTable.setInt(28, ectsPortfolioW);
            insertCourseWorkloadTable.setInt(29, ectsWorkshopN);
            insertCourseWorkloadTable.setInt(30, ectsWorkshopDH);
            insertCourseWorkloadTable.setInt(31, ectsWorkshopW);
            insertCourseWorkloadTable.setInt(32, ectsOralexamN);
            insertCourseWorkloadTable.setInt(33, ectsOralexamDH);
            insertCourseWorkloadTable.setInt(34, ectsOralexamW);
            insertCourseWorkloadTable.setInt(35, ectsMidtermN);
            insertCourseWorkloadTable.setInt(36, ectsMidtermDH);
            insertCourseWorkloadTable.setInt(37, ectsMidtermW);
            insertCourseWorkloadTable.setInt(38, ectsFinalN);
            insertCourseWorkloadTable.setInt(39, ectsFinalDH);
            insertCourseWorkloadTable.setInt(40, ectsFinalW);

            insertCourseWorkloadTable.execute();

        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public void addCourseWeeklySchedule(Syllabus syllabus) {
        try {
            int schedule_id ;

            String weeklysub_1sub = syllabus.W1sub;
            String weeklysub_1req = syllabus.W1req;
            String weeklysub_2sub = syllabus.W2sub;
            String weeklysub_2req = syllabus.W2req;
            String weeklysub_3sub = syllabus.W3sub;
            String weeklysub_3req = syllabus.W3req;
            String weeklysub_4sub = syllabus.W4sub;
            String weeklysub_4req = syllabus.W4req;
            String weeklysub_5sub = syllabus.W5sub;
            String weeklysub_5req = syllabus.W5req;
            String weeklysub_6sub = syllabus.W6sub;
            String weeklysub_6req = syllabus.W6req;
            String weeklysub_7sub = syllabus.W7sub;
            String weeklysub_7req = syllabus.W7req;
            String weeklysub_8sub = syllabus.W8sub;
            String weeklysub_8req = syllabus.W8req;
            String weeklysub_9sub = syllabus.W9sub;
            String weeklysub_9req = syllabus.W9req;
            String weeklysub_10sub = syllabus.W10sub;
            String weeklysub_10req = syllabus.W10req;
            String weeklysub_11sub = syllabus.W11sub;
            String weeklysub_11req = syllabus.W11req;
            String weeklysub_12sub = syllabus.W12sub;
            String weeklysub_12req = syllabus.W12req;
            String weeklysub_13sub = syllabus.W13sub;
            String weeklysub_13req = syllabus.W13req;
            String weeklysub_14sub = syllabus.W14sub;
            String weeklysub_14req = syllabus.W14req;
            String weeklysub_15sub = syllabus.W15sub;
            String weeklysub_15req = syllabus.W15req;
            String weeklysub_16sub = syllabus.W16sub;
            String weeklysub_16req = syllabus.W16req;
            String weeklysub_coursenotes = syllabus.courseNotesTextbooks;
            String weeklysub_suggmat = syllabus.SuggestedReadings;

            PreparedStatement insertCourseWeeklySchedule = connection.prepareStatement("INSERT INTO CourseWeeklySchedule (schedule_id,weeklysub_1sub, weeklysub_1req,weeklysub_2sub, weeklysub_2req,weeklysub_3sub, weeklysub_3req,weeklysub_4sub, weeklysub_4req,weeklysub_5sub, weeklysub_5req,weeklysub_6sub, weeklysub_6req,weeklysub_7sub, weeklysub_7req,weeklysub_8sub, weeklysub_8req,weeklysub_9sub, weeklysub_9req,weeklysub_10sub, weeklysub_10req,weeklysub_11sub, weeklysub_11req,weeklysub_12sub, weeklysub_12req,weeklysub_13sub, weeklysub_13req,weeklysub_14sub, weeklysub_14req,weeklysub_15sub, weeklysub_15req,weeklysub_16sub, weeklysub_16req,weeklysub_coursenotes, weeklysub_suggmat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)");

            /*insertCourseWeeklySchedule.setInt(1, schedule_id);*/
            insertCourseWeeklySchedule.setString(2, weeklysub_1sub);
            insertCourseWeeklySchedule.setString(3, weeklysub_1req);
            insertCourseWeeklySchedule.setString(4, weeklysub_2sub);
            insertCourseWeeklySchedule.setString(5, weeklysub_2req);
            insertCourseWeeklySchedule.setString(6, weeklysub_3sub);
            insertCourseWeeklySchedule.setString(7, weeklysub_3req);
            insertCourseWeeklySchedule.setString(8, weeklysub_4sub);
            insertCourseWeeklySchedule.setString(9, weeklysub_4req);
            insertCourseWeeklySchedule.setString(10, weeklysub_5sub);
            insertCourseWeeklySchedule.setString(11, weeklysub_5req);
            insertCourseWeeklySchedule.setString(12, weeklysub_6sub);
            insertCourseWeeklySchedule.setString(13, weeklysub_6req);
            insertCourseWeeklySchedule.setString(14, weeklysub_7sub);
            insertCourseWeeklySchedule.setString(15, weeklysub_7req);
            insertCourseWeeklySchedule.setString(16, weeklysub_8sub);
            insertCourseWeeklySchedule.setString(17, weeklysub_8req);
            insertCourseWeeklySchedule.setString(18, weeklysub_9sub);
            insertCourseWeeklySchedule.setString(19, weeklysub_9req);
            insertCourseWeeklySchedule.setString(20, weeklysub_10sub);
            insertCourseWeeklySchedule.setString(21, weeklysub_10req);
            insertCourseWeeklySchedule.setString(22, weeklysub_11sub);
            insertCourseWeeklySchedule.setString(23, weeklysub_11req);
            insertCourseWeeklySchedule.setString(24, weeklysub_12sub);
            insertCourseWeeklySchedule.setString(25, weeklysub_12req);
            insertCourseWeeklySchedule.setString(26, weeklysub_13sub);
            insertCourseWeeklySchedule.setString(27, weeklysub_13req);
            insertCourseWeeklySchedule.setString(28, weeklysub_14sub);
            insertCourseWeeklySchedule.setString(29, weeklysub_14req);
            insertCourseWeeklySchedule.setString(30, weeklysub_15sub);
            insertCourseWeeklySchedule.setString(31, weeklysub_15req);
            insertCourseWeeklySchedule.setString(32, weeklysub_16sub);
            insertCourseWeeklySchedule.setString(33, weeklysub_16req);
            insertCourseWeeklySchedule.setString(34, weeklysub_coursenotes);
            insertCourseWeeklySchedule.setString(35, weeklysub_suggmat);

            insertCourseWeeklySchedule.execute();

        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public void addCourseOutcomeTable(int version, String lo, String outcome, int contributionLevel) {
        try {
            PreparedStatement insertCourseOutcomeTable = connection.prepareStatement("INSERT INTO CourseOutcomeTable (version,lo,outcome,contributionLevel) VALUES (?,?,?,?)");
            insertCourseOutcomeTable.setInt(1, version);
            insertCourseOutcomeTable.setString(2, lo);
            insertCourseOutcomeTable.setString(3, outcome);
            insertCourseOutcomeTable.setInt(4, contributionLevel);

            insertCourseOutcomeTable.execute();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void addSyllabus(Syllabus syllabus) {
        /*try {
            addCourseMainTable(syllabus);
            addCourseInformationTable(syllabus);
            addCourseAssessmentTable(syllabus);
            addCourseWorkloadTable(syllabus);
            addCourseWeeklySchedule(syllabus);
            addCourseOutcomeTable(syllabus);
        } catch (Exception e) {
            System.err.println(e);
        }*/
    }

}