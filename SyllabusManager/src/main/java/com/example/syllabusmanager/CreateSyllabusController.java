package com.example.syllabusmanager;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;


public class CreateSyllabusController implements Initializable {

    int numberOfOutcomes = 0; //number of outcomes, it will be incremented after every successful "add" button action
    Alert a = new Alert(Alert.AlertType.NONE);
    Alert b = new Alert(Alert.AlertType.NONE);
    //General info
    //General info code
    @FXML
    private TextField code_TextF_GeneralInf;
    //General info fall/spring
    @FXML
    private RadioButton fall_RadioB_GeneralInf, spring_RadioB_GeneralInf;

    public int generalInfo_FallSpringRadiobutton() {

        if (fall_RadioB_GeneralInf.isSelected()) {
            return 0;
        } else if (spring_RadioB_GeneralInf.isSelected()) {
            return 1;
        } else {
            return -1;
        }
    }
    // RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();

    //General info theory
    @FXML
    private TextField theory_TextF_GeneralInf;
    //General info lab
    @FXML
    private TextField lab_TextF_GeneralInf;
    //General info local credits
    @FXML
    private TextField local_TextF_GeneralInf;
    //General info prerequisites
    @FXML
    private TextField prerequisities_TextF_GeneralInf;
    //General info course language
    @FXML
    private RadioButton courseL_Turkish_RadioB_GeneralInf, courseL_English_RadioB_GeneralInf, courseL_SecondFL_RadioB_GeneralInf;

    public int generalInfo_courselanguage() {

        if (courseL_Turkish_RadioB_GeneralInf.isSelected()) {
            return 0;
        } else if (courseL_English_RadioB_GeneralInf.isSelected()) {
            return 1;
        } else if (courseL_SecondFL_RadioB_GeneralInf.isSelected()) {
            return 2;
        } else {
            return -1;// change with warning screen
        }
    }

    //General info course type
    @FXML
    private RadioButton courseT_Required_RadioB_GeneralInf, courseT_Elective_RadioB_GeneralInf;

    public int generalInfo_coursetype() {

        if (courseT_Required_RadioB_GeneralInf.isSelected()) {
            return 0;
        } else if (courseT_Elective_RadioB_GeneralInf.isSelected()) {
            return 1;
        } else {
            return -1;
        }
    }

    //General info course level
    @FXML
    private RadioButton CoruseL_ShortC_RadioB_GeneralInf, CoruseL_FirstC_RadioB_GeneralInf,
            CoruseL_SecondC_RadioB_GeneralInf, CoruseL_ThirdC_RadioB_GeneralInf;

    public int generalInfo_courselevel() {

        if (CoruseL_ShortC_RadioB_GeneralInf.isSelected()) {
            return 0;
        } else if (CoruseL_FirstC_RadioB_GeneralInf.isSelected()) {
            return 1;
        } else if (CoruseL_SecondC_RadioB_GeneralInf.isSelected()) {
            return 2;
        } else if (CoruseL_ThirdC_RadioB_GeneralInf.isSelected()) {
            return 3;
        } else {
            return -1;
        }
    }

    //General info mode of delivery
    @FXML
    private RadioButton ModeofD_Face2Face_RadioB_GeneralInf, ModeofD_Blended_RadioB_GeneralInf,
            ModeofD_Online_RadioB_GeneralInf;

    public int generalInfo_modeofdelivery() {

        if (ModeofD_Face2Face_RadioB_GeneralInf.isSelected()) {
            return 0;
        } else if (ModeofD_Blended_RadioB_GeneralInf.isSelected()) {
            return 1;
        } else if (ModeofD_Online_RadioB_GeneralInf.isSelected()) {
            return 2;
        } else {
            return -1;
        }
    }

    //General info teaching methods
    @FXML
    private TextArea TeachingM_TextF_GeneralInf;
    //General info course coordinator
    @FXML
    private TextField courseCoordinator_TextF_GeneralInf;
    //General info course lecturer
    @FXML
    private TextField courseLecturer_TextF_GeneralInf;
    //General info course assistant
    @FXML
    private TextArea assistant_TextF_GeneralInf;
    //General info course objectives
    @FXML
    private TextArea courseObj_TextF_GeneralInf;
    //General info learning outcomes
    @FXML
    private TextArea learningO_TextF_GeneralInf;
    //General info course category
    @FXML
    private RadioButton lo_CoreCourse_RadioB_GeneralInf, lo_CommunicationManagement_RadioB_GeneralInf,
            lo_MajorArea_RadioB_GeneralInf, lo_TransSkillCourse_RadioB_GeneralInf,
            lo_SupCourse_RadioB_GeneralInf;

    public int generalInfo_coursecategory() {

        if (lo_CoreCourse_RadioB_GeneralInf.isSelected()) {
            return 0;
        } else if (lo_CommunicationManagement_RadioB_GeneralInf.isSelected()) {
            return 1;
        } else if (lo_MajorArea_RadioB_GeneralInf.isSelected()) {
            return 2;
        } else if (lo_TransSkillCourse_RadioB_GeneralInf.isSelected()) {
            return 3;
        } else if (lo_SupCourse_RadioB_GeneralInf.isSelected()) {
            return 4;
        } else {

            return -1;
        }
    }

    //Weekly subjects
    //WEEK1
    @FXML
    private TextArea subjects1_TextF_WeeklySub;
    @FXML
    private TextArea RequiredM1_TextF_WeeklySub;
    //WEEK2
    @FXML
    private TextArea subjects2_TextF_WeeklySub;
    @FXML
    private TextArea RequiredM2_TextF_WeeklySub;
    //WEEK3
    @FXML
    private TextArea subjects3_TextF_WeeklySub;
    @FXML
    private TextArea RequiredM3_TextF_WeeklySub;
    //WEEK4
    @FXML
    private TextArea subjects4_TextF_WeeklySub;
    @FXML
    private TextArea RequiredM4_TextF_WeeklySub;
    //WEEK5
    @FXML
    private TextArea subjects5_TextF_WeeklySub;
    @FXML
    private TextArea RequiredM5_TextF_WeeklySub;
    //WEEK6
    @FXML
    private TextArea subjects6_TextF_WeeklySub;
    @FXML
    private TextArea RequiredM6_TextF_WeeklySub;
    //WEEK7
    @FXML
    private TextArea subjects7_TextF_WeeklySub;
    @FXML
    private TextArea RequiredM7_TextF_WeeklySub;
    //WEEK8
    @FXML
    private TextArea subjects8_TextF_WeeklySub;
    @FXML
    private TextArea RequiredM8_TextF_WeeklySub;
    //WEEK9
    @FXML
    private TextArea subjects9_TextF_WeeklySub;
    @FXML
    private TextArea RequiredM9_TextF_WeeklySub;
    //WEEK10
    @FXML
    private TextArea subjects10_TextF_WeeklySub;
    @FXML
    private TextArea RequiredM10_TextF_WeeklySub;
    //WEEK11
    @FXML
    private TextArea subjects11_TextF_WeeklySub;
    @FXML
    private TextArea RequiredM11_TextF_WeeklySub;
    //WEEK12
    @FXML
    private TextArea subjects12_TextF_WeeklySub;
    @FXML
    private TextArea RequiredM12_TextF_WeeklySub;
    //WEEK13
    @FXML
    private TextArea subjects13_TextF_WeeklySub;
    @FXML
    private TextArea RequiredM13_TextF_WeeklySub;
    //WEEK14
    @FXML
    private TextArea subjects14_TextF_WeeklySub;
    @FXML
    private TextArea RequiredM14_TextF_WeeklySub;
    //WEEK15
    @FXML
    private TextArea subjects15_TextF_WeeklySub;
    @FXML
    private TextArea RequiredM15_TextF_WeeklySub;
    //WEEK16
    @FXML
    private TextArea subjects16_TextF_WeeklySub;
    @FXML
    private TextArea RequiredM16_TextF_WeeklySub;
    //Course notes and suggested readings
    @FXML
    private TextArea courseNotes_TextF_WeeklySub;
    @FXML
    private TextArea suggestedMaterials_TextF_WeeklySub;
//Assessment

    UnaryOperator<TextFormatter.Change> filter = change -> {
        String newText = change.getControlNewText();
        if (Pattern.matches("\\d*", newText)) {
            return change;
        } else {
            return null;
        }
    };
    //TextFormatter<String> textFormatter = new TextFormatter<>(filter);


    //participation
    @FXML
    private TextField participationN_TextF_Assessment;
    @FXML
    private TextField participationW_TextF_Assessment;
    @FXML
    private TextField participationLO_TextF_Assessment;
    //lab
    @FXML
    private TextField labN_TextF_Assessment;
    @FXML
    private TextField labW_TextF_Assessment;
    @FXML
    private TextField labLO_TextF_Assessment;
    //field work
    @FXML
    private TextField fieldWorkN_TextF_Assessment;
    @FXML
    private TextField fieldWorkW_TextF_Assessment;
    @FXML
    private TextField fieldWorkLO_TextF_Assessment;
    //quiz
    @FXML
    private TextField quizCritiqueN_TextF_Assessment;
    @FXML
    private TextField quizCritiqueW_TextF_Assessment;
    @FXML
    private TextField quizCritiqueLO_TextF_Assessment;
    //homework
    @FXML
    private TextField homeworkN_TextF_Assessment;
    @FXML
    private TextField homeworkW_TextF_Assessment;
    @FXML
    private TextField homeworkLO_TextF_Assessment;
    //presentation
    @FXML
    private TextField presentationN_TextF_Assessment;
    @FXML
    private TextField presentationW_TepresentationN_TextF_AssessmentxtF2_Assessment;
    @FXML
    private TextField presentationLO_TextF_Assessment;
    //project
    @FXML
    private TextField projectN_TextF_Assessment;
    @FXML
    private TextField projectW_TextF_Assessment;
    @FXML
    private TextField projectLO_TextF_Assessment;
    //portfolio
    @FXML
    private TextField protfolioN_TextF_Assessment;
    @FXML
    private TextField protfolioW_TextF_Assessment;
    @FXML
    private TextField protfolioLO_TextF_Assessment;
    //seminar
    @FXML
    private TextField workshopN_TextF_Assessment;
    @FXML
    private TextField workshopW_TextF_Assessment;
    @FXML
    private TextField workshopLO_TextF_Assessment;
    //oral exam
    @FXML
    private TextField oralExamN_TextF_Assessment;
    @FXML
    private TextField oralExamW_TextF_Assessment;
    @FXML
    private TextField oralExamLO_TextF_Assessment;
    //midterm
    @FXML
    private TextField midtermN_TextF_Assessment;
    @FXML
    private TextField midtermW_TextF_Assessment;
    @FXML
    private TextField midtermLO_TextF_Assessment;
    //final exam
    @FXML
    private TextField finalExamN_TextF_Assessment;
    @FXML
    private TextField finalExamW_TextF_Assessment;
    @FXML
    private TextField finalExamLO_TextF_Assessment;
    //Weighting of Semester Activities on the Final Grade
    @FXML
    private TextField weightingofSemesterN_TextF_Assessment;
    @FXML
    private TextField weightingofSemesterW_TextF_Assessment;
    @FXML
    private TextField weightingofSemesterLO_TextF_Assessment;
    //Weighting of End-of-Semester Activities on the Final Grade
    @FXML
    private TextField weightingofEndSemesterN_TextF_Assessment;
    @FXML
    private TextField weightingofEndSemesterW_TextF_Assessment;
    @FXML
    private TextField weightingofEndSemesterLO_TextF_Assessment;
    //ECTS / Workload Table
    //course hour
    @FXML
    private TextField courseHourN_TextF_WorkloadTable;
    @FXML
    private TextField courseHourDH_TextF_WorkloadTable;
    @FXML
    private TextField courseHourW_TextF_WorkloadTable;
    //lab hour
    @FXML
    private TextField LabHourN_TextF_WorkloadTable;
    @FXML
    private TextField LabHourDH_TextF_WorkloadTable;
    @FXML
    private TextField LabHourW_TextF_WorkloadTable;
    //study hour
    @FXML
    private TextField studyHourN_TextF_WorkloadTable;
    @FXML
    private TextField studyHourDH_TextF_WorkloadTable;
    @FXML
    private TextField studyHourW_TextF_WorkloadTable;
    //field work
    @FXML
    private TextField fieldWN_TextF_WorkloadTable;
    @FXML
    private TextField fieldWDH_TextF_WorkloadTable;
    @FXML
    private TextField fieldWW_TextF_WorkloadTable;
    //quiz
    @FXML
    private TextField quizN_TextF_WorkloadTable;
    @FXML
    private TextField quizDH_TextF_WorkloadTable;
    @FXML
    private TextField quizW_TextF_WorkloadTable;
    //homework
    @FXML
    private TextField homeWN_TextF_WorkloadTable;
    @FXML
    private TextField homeWDH_TextF_WorkloadTable;
    @FXML
    private TextField homeWW_TextF_WorkloadTable;
    //presentation
    @FXML
    private TextField presentationN_TextF_WorkloadTable;
    @FXML
    private TextField presentationDH_TextF_WorkloadTable;
    @FXML
    private TextField presentationW_TextF_WorkloadTable;
    //project
    @FXML
    private TextField projectN_TextF_WorkloadTable;
    @FXML
    private TextField projectDH_TextF_WorkloadTable;
    @FXML
    private TextField projectW_TextF_WorkloadTable;
    //portfolio
    @FXML
    private TextField portfolioN_TextF_WorkloadTable;
    @FXML
    private TextField portfolioDH_TextF_WorkloadTable;
    @FXML
    private TextField portfolioW_TextF_WorkloadTable;
    //seminar workshop
    @FXML
    private TextField workshopN_TextF_WorkloadTable;
    @FXML
    private TextField workshopDH_TextF_WorkloadTable;
    @FXML
    private TextField workshopW_TextF_WorkloadTable;
    //oral exam
    @FXML
    private TextField oralExamN_TextF_WorkloadTable;
    @FXML
    private TextField oralExamDH_TextF_WorkloadTable;
    @FXML
    private TextField oralExamW_TextF_WorkloadTable;
    //midterm
    @FXML
    private TextField midtermN_TextF_WorkloadTable;
    @FXML
    private TextField midtermDH_TextF_WorkloadTable;
    @FXML
    private TextField midtermW_TextF_WorkloadTable;
    //final exam
    @FXML
    private TextField finalExamN_TextF_WorkloadTable;
    @FXML
    private TextField finalExamDH_TextF_WorkloadTable;
    @FXML
    private TextField finalExamW_TextF_WorkloadTable;
    //Course/Program Outcome Matrix
    @FXML
    private TextArea programCompetencies_TextF_CourseOutcomes;
    @FXML
    private RadioButton ContrLevel1_RadioB_GeneralInf, ContrLevel2_RadioB_GeneralInf,
            ContrLevel3_RadioB_GeneralInf, ContrLevel4_RadioB_GeneralInf,
            ContrLevel5_RadioB_GeneralInf;
    @FXML
    private TextField LO_TextF_GeneralInf;

    @FXML
    private TableColumn<ProgramOutcomedata, String> outcomesTableView_OutcomeMatrixcolumn;

    @FXML
    private TableColumn<ProgramOutcomedata, Integer> contributionLevel_OutcomeMatrixcolumn;
    @FXML
    private TableColumn<ProgramOutcomedata, String> LO_OutcomeMatrixcolumn;

    @FXML
    private TableView<ProgramOutcomedata> table_OutcomeMatrixt;


    class ProgramOutcomedata {
        String outcomesTableView;
        Integer contributionLevel;
        String LO;

        public String getOutcomesTableView() {
            return outcomesTableView;
        }

        public Integer getContributionLevel() {
            return contributionLevel;
        }

        public String getLO() {
            return LO;
        }

        public ProgramOutcomedata(String outcomesTableView, Integer contributionLevel, String LO) {
            this.outcomesTableView = outcomesTableView;
            this.contributionLevel = contributionLevel;
            this.LO = LO;
        }
    }

    @FXML
    private void addButtonFunction_CreateSyllabusPage(ActionEvent event) {

        if (!programCompetencies_TextF_CourseOutcomes.getText().isEmpty() &&
                outcomematix_contributionlevel() != -1 &&
                !LO_TextF_GeneralInf.getText().isEmpty()) {//numberofoutcomes yerine version girilicek
            DBConnector.getInstance().addCourseOutcomeTable(++numberOfOutcomes, LO_TextF_GeneralInf.getText(), programCompetencies_TextF_CourseOutcomes.getText(), outcomematix_contributionlevel());


            ProgramOutcomedata newData = new ProgramOutcomedata
                    (programCompetencies_TextF_CourseOutcomes.getText(), outcomematix_contributionlevel(), LO_TextF_GeneralInf.getText());

            table_OutcomeMatrixt.getItems().add(newData);

            programCompetencies_TextF_CourseOutcomes.clear();
            LO_TextF_GeneralInf.clear();
        }


    }

    public Integer outcomematix_contributionlevel() {

        if (ContrLevel1_RadioB_GeneralInf.isSelected()) {
            return 1;
        } else if (ContrLevel2_RadioB_GeneralInf.isSelected()) {
            return 2;
        } else if (ContrLevel3_RadioB_GeneralInf.isSelected()) {
            return 3;
        } else if (ContrLevel4_RadioB_GeneralInf.isSelected()) {
            return 4;
        } else if (ContrLevel5_RadioB_GeneralInf.isSelected()) {
            return 5;
        } else {

            return -1;
        }
    }




    public void initialize(URL location, ResourceBundle resources) {

        init();
    }






    public void init() {
        numberOfOutcomes = 0;
        subjects15_TextF_WeeklySub.setEditable(false);
        subjects16_TextF_WeeklySub.setEditable(false);


        participationN_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        participationW_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        participationLO_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        //lab
        labN_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        labW_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        labLO_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        //field work
        fieldWorkN_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        fieldWorkW_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        fieldWorkLO_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        //quiz
        quizCritiqueN_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        quizCritiqueW_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        quizCritiqueLO_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        //homework
        homeworkN_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        homeworkW_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        homeworkLO_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        //presentation
        presentationN_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        presentationW_TepresentationN_TextF_AssessmentxtF2_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        presentationLO_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        //project
        projectN_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        projectW_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        projectLO_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        //portfolio
        protfolioN_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        protfolioW_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        protfolioLO_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        //seminar
        workshopN_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        workshopW_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        workshopLO_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        //oral exam
        oralExamN_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        oralExamW_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        oralExamLO_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        //midterm
        midtermN_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        midtermW_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        midtermLO_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        //final exam
        finalExamN_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        finalExamW_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        finalExamLO_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        //Weighting of Semester Activities on the Final Grade
        weightingofSemesterN_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        weightingofSemesterW_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        weightingofSemesterLO_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        //Weighting of End-of-Semester Activities on the Final Grade
        weightingofEndSemesterN_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        weightingofEndSemesterW_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));
        weightingofEndSemesterLO_TextF_Assessment.setTextFormatter(new TextFormatter<String>(filter));

        //ECTS / Workload Table

        //course hour
        courseHourN_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        courseHourDH_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        courseHourW_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        //lab hour
        LabHourN_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        LabHourDH_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        LabHourW_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        //study hour
        studyHourN_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        studyHourDH_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        studyHourW_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        //field work
        fieldWN_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        fieldWDH_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        fieldWW_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        //quiz
        quizN_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        quizDH_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        quizW_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        //homework
        homeWN_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        homeWDH_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        homeWW_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        //presentation
        presentationN_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        presentationDH_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        presentationW_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        //project
        projectN_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        projectDH_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        projectW_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        //portfolio
        portfolioN_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        portfolioDH_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        portfolioW_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        //seminar workshop
        workshopN_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        workshopDH_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        workshopW_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        //oral exam
        oralExamN_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        oralExamDH_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        oralExamW_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        //midterm
        midtermN_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        midtermDH_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        midtermW_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        //final exam
        finalExamN_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        finalExamDH_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));
        finalExamW_TextF_WorkloadTable.setTextFormatter(new TextFormatter<String>(filter));


        local_TextF_GeneralInf.setTextFormatter(new TextFormatter<String>(filter));
        theory_TextF_GeneralInf.setTextFormatter(new TextFormatter<String>(filter));
        lab_TextF_GeneralInf.setTextFormatter(new TextFormatter<String>(filter));


        outcomesTableView_OutcomeMatrixcolumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getOutcomesTableView());
        });

        //contributionLevel_OutcomeMatrixcolumn.setCellValueFactory(cellData -> {
        //return new SimpleIntegerProperty(cellData.getValue().getContributionLevel());
        //});

        contributionLevel_OutcomeMatrixcolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ProgramOutcomedata, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<ProgramOutcomedata, Integer> param) {

                return new SimpleIntegerProperty(param.getValue().getContributionLevel()).asObject();
            }
        });


        LO_OutcomeMatrixcolumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getLO());
        });


    }


    @FXML
    private void saveallButtonFunction_CreateSyllabus(ActionEvent event) {
        numberOfOutcomes = 0;
        //init();

        //subjects16_TextF_WeeklySub.setEditable(false);
        //subjects16_TextF_WeeklySub.setEditable(false);

        //General Info
        Boolean saveallkey = true;

        List<TextField> textFields = Arrays.asList(
                code_TextF_GeneralInf, theory_TextF_GeneralInf, lab_TextF_GeneralInf,
                local_TextF_GeneralInf, prerequisities_TextF_GeneralInf, courseCoordinator_TextF_GeneralInf,
                courseLecturer_TextF_GeneralInf);




        for (TextField field : textFields) {
            if (field.getText() == null || field.getText().trim().isEmpty()) {
                saveallkey = false; //this is not working
                break;
            }
        }

        List<TextArea> textAreas = Arrays.asList(learningO_TextF_GeneralInf,
                courseObj_TextF_GeneralInf, assistant_TextF_GeneralInf, TeachingM_TextF_GeneralInf);
        for (TextField area : textFields) {
            if (area.getText() == null || area.getText().trim().isEmpty()) {
                saveallkey = false; //this is not working
                break;
            }
        }


        String generalInfo_Code = code_TextF_GeneralInf.getText();
        String generalInfo_Theory = theory_TextF_GeneralInf.getText();
        String generalInfo_Lab = lab_TextF_GeneralInf.getText();

        String generalInfo_localCreditstext = local_TextF_GeneralInf.getText();
        int generalInfo_localCredits = generalInfo_localCreditstext.isEmpty() ? 0 : Integer.parseInt(generalInfo_localCreditstext);

        String generalInfo_Prerequisites = prerequisities_TextF_GeneralInf.getText();
        String generalInfo_Teachingmethods = TeachingM_TextF_GeneralInf.getText();
        String generalInfo_CourseCoordinator = courseCoordinator_TextF_GeneralInf.getText();
        String generalInfo_CourseLecturer = courseLecturer_TextF_GeneralInf.getText();
        String generalInfo_CourseAssistant = assistant_TextF_GeneralInf.getText();
        String generalInfo_CourseObjectives = courseObj_TextF_GeneralInf.getText();
        String generalInfo_Learningoutcomes = learningO_TextF_GeneralInf.getText();


        int generalInfo_FallSpring = generalInfo_FallSpringRadiobutton();
        int generalInfo_courseLanguage = generalInfo_courselanguage();
        int generalInfo_courseType = generalInfo_coursetype();
        int generalInfo_courseLevel = generalInfo_courselevel();
        int generalInfo_Modeofdelivery = generalInfo_modeofdelivery();
        int generalInfo_CourseCategory = generalInfo_coursecategory();

        List<Integer> generalinfo_Radiobuttons = Arrays.asList(
                generalInfo_FallSpring, generalInfo_courseLanguage, generalInfo_courseType,
                generalInfo_courseLevel, generalInfo_Modeofdelivery, generalInfo_CourseCategory);
        for (Integer value : generalinfo_Radiobuttons) {
            if (value == -1) {
                saveallkey = false; //and also this one not working
                break;
            }
        }


        //Weekly subjects
        String weeklysub_1sub = subjects1_TextF_WeeklySub.getText();
        String weeklysub_1req = RequiredM1_TextF_WeeklySub.getText();

        String weeklysub_2sub = subjects2_TextF_WeeklySub.getText();
        String weeklysub_2req = RequiredM2_TextF_WeeklySub.getText();

        String weeklysub_3sub = subjects3_TextF_WeeklySub.getText();
        String weeklysub_3req = RequiredM3_TextF_WeeklySub.getText();

        String weeklysub_4sub = subjects4_TextF_WeeklySub.getText();
        String weeklysub_4req = RequiredM4_TextF_WeeklySub.getText();

        String weeklysub_5sub = subjects5_TextF_WeeklySub.getText();
        String weeklysub_5req = RequiredM5_TextF_WeeklySub.getText();

        String weeklysub_6sub = subjects6_TextF_WeeklySub.getText();
        String weeklysub_6req = RequiredM6_TextF_WeeklySub.getText();

        String weeklysub_7sub = subjects7_TextF_WeeklySub.getText();
        String weeklysub_7req = RequiredM7_TextF_WeeklySub.getText();

        String weeklysub_8sub = subjects8_TextF_WeeklySub.getText();
        String weeklysub_8req = RequiredM8_TextF_WeeklySub.getText();

        String weeklysub_9sub = subjects9_TextF_WeeklySub.getText();
        String weeklysub_9req = RequiredM9_TextF_WeeklySub.getText();

        String weeklysub_10sub = subjects10_TextF_WeeklySub.getText();
        String weeklysub_10req = RequiredM10_TextF_WeeklySub.getText();

        String weeklysub_11sub = subjects11_TextF_WeeklySub.getText();
        String weeklysub_11req = RequiredM11_TextF_WeeklySub.getText();

        String weeklysub_12sub = subjects12_TextF_WeeklySub.getText();
        String weeklysub_12req = RequiredM12_TextF_WeeklySub.getText();

        String weeklysub_13sub = subjects13_TextF_WeeklySub.getText();
        String weeklysub_13req = RequiredM13_TextF_WeeklySub.getText();

        String weeklysub_14sub = subjects14_TextF_WeeklySub.getText();
        String weeklysub_14req = RequiredM14_TextF_WeeklySub.getText();

        String weeklysub_15sub = subjects15_TextF_WeeklySub.getText();
        String weeklysub_15req = RequiredM15_TextF_WeeklySub.getText();

        String weeklysub_16sub = subjects16_TextF_WeeklySub.getText();
        String weeklysub_16req = RequiredM16_TextF_WeeklySub.getText();

        String weeklysub_coursenotes = courseNotes_TextF_WeeklySub.getText();
        String weeklysub_suggmat = suggestedMaterials_TextF_WeeklySub.getText();


        //Assessment

        //int assesParticipN = Integer.parseInt(participationN_TextF_Assessment.getText());
        String participNText = participationN_TextF_Assessment.getText();
        int assesParticipN = participNText.isEmpty() ? 0 : Integer.parseInt(participNText);
        System.out.println(assesParticipN);

        //int assesParticipW = Integer.parseInt(participationW_TextF_Assessment.getText());
        String ParticipWtext = participationW_TextF_Assessment.getText();
        int assesParticipW = ParticipWtext.isEmpty() ? 0 : Integer.parseInt(ParticipWtext);

        //int assesParticipLO = Integer.parseInt(participationLO_TextF_Assessment.getText());
        String ParticipLOtext = participationLO_TextF_Assessment.getText();
        int assesParticipLO = ParticipLOtext.isEmpty() ? 0 : Integer.parseInt(ParticipLOtext);

        //int assesLabN = Integer.parseInt(labN_TextF_Assessment.getText());
        String LabNtext = labN_TextF_Assessment.getText();
        int assesLabN = LabNtext.isEmpty() ? 0 : Integer.parseInt(LabNtext);

        //int assesLabW = Integer.parseInt(labW_TextF_Assessment.getText());
        String LabWtext = labW_TextF_Assessment.getText();
        int assesLabW = LabWtext.isEmpty() ? 0 : Integer.parseInt(LabWtext);

        //int assesLabLO = Integer.parseInt(labLO_TextF_Assessment.getText());
        String LabLOtext = labLO_TextF_Assessment.getText();
        int assesLabLO = LabLOtext.isEmpty() ? 0 : Integer.parseInt(LabLOtext);

        //int assesFiledN = Integer.parseInt(fieldWorkN_TextF_Assessment.getText());
        String FiledNtext = fieldWorkN_TextF_Assessment.getText();
        int assesFiledN = FiledNtext.isEmpty() ? 0 : Integer.parseInt(FiledNtext);

        //int assesFiledW = Integer.parseInt(fieldWorkW_TextF_Assessment.getText());
        String FiledWtext = fieldWorkW_TextF_Assessment.getText();
        int assesFiledW = FiledWtext.isEmpty() ? 0 : Integer.parseInt(FiledWtext);

        //int assesFiledLO = Integer.parseInt(fieldWorkLO_TextF_Assessment.getText());
        String FiledLOtext = fieldWorkLO_TextF_Assessment.getText();
        int assesFiledLO = FiledLOtext.isEmpty() ? 0 : Integer.parseInt(FiledLOtext);

        //int assesQuizN = Integer.parseInt(quizCritiqueN_TextF_Assessment.getText());
        String QuizNtext = quizCritiqueN_TextF_Assessment.getText();
        int assesQuizN = QuizNtext.isEmpty() ? 0 : Integer.parseInt(QuizNtext);

        //int assesQuizW = Integer.parseInt(quizCritiqueW_TextF_Assessment.getText());
        String QuizWtext = quizCritiqueW_TextF_Assessment.getText();
        int assesQuizW = QuizWtext.isEmpty() ? 0 : Integer.parseInt(QuizWtext);

        //int assesQuizLO = Integer.parseInt(quizCritiqueLO_TextF_Assessment.getText());
        String QuizLOtext = quizCritiqueLO_TextF_Assessment.getText();
        int assesQuizLO = QuizLOtext.isEmpty() ? 0 : Integer.parseInt(QuizLOtext);

        //int assesHomewN = Integer.parseInt(homeworkN_TextF_Assessment.getText());
        String HomewNtext = homeworkN_TextF_Assessment.getText();
        int assesHomewN = HomewNtext.isEmpty() ? 0 : Integer.parseInt(HomewNtext);

        //int assesHomewW = Integer.parseInt(homeworkW_TextF_Assessment.getText());
        String HomewWtext = homeworkW_TextF_Assessment.getText();
        int assesHomewW = HomewWtext.isEmpty() ? 0 : Integer.parseInt(HomewWtext);

        //int assesHomewLO = Integer.parseInt(homeworkLO_TextF_Assessment.getText());
        String HomewLOtext = homeworkLO_TextF_Assessment.getText();
        int assesHomewLO = HomewLOtext.isEmpty() ? 0 : Integer.parseInt(HomewLOtext);

        //int assesPresentN = Integer.parseInt(presentationN_TextF_Assessment.getText());
        String PresentNtext = presentationN_TextF_Assessment.getText();
        int assesPresentN = PresentNtext.isEmpty() ? 0 : Integer.parseInt(PresentNtext);

        //int assesPresentW = Integer.parseInt(presentationW_TepresentationN_TextF_AssessmentxtF2_Assessment.getText());
        String PresentWtext = presentationW_TepresentationN_TextF_AssessmentxtF2_Assessment.getText();
        int assesPresentW = PresentWtext.isEmpty() ? 0 : Integer.parseInt(PresentWtext);

        //int assesPresentLO = Integer.parseInt(presentationLO_TextF_Assessment.getText());
        String PresentLOtext = presentationLO_TextF_Assessment.getText();
        int assesPresentLO = PresentLOtext.isEmpty() ? 0 : Integer.parseInt(PresentLOtext);

        //int assesProjectN = Integer.parseInt(projectN_TextF_Assessment.getText());
        String ProjectNtext = projectN_TextF_Assessment.getText();
        int assesProjectN = ProjectNtext.isEmpty() ? 0 : Integer.parseInt(ProjectNtext);

        //int assesProjectW = Integer.parseInt(projectW_TextF_Assessment.getText());
        String ProjectWtext = projectW_TextF_Assessment.getText();
        int assesProjectW = ProjectWtext.isEmpty() ? 0 : Integer.parseInt(ProjectWtext);

        //int assesProjectLO = Integer.parseInt(projectLO_TextF_Assessment.getText());
        String ProjectLOtext = projectLO_TextF_Assessment.getText();
        int assesProjectLO = ProjectLOtext.isEmpty() ? 0 : Integer.parseInt(ProjectLOtext);

        //int assesPortfolN = Integer.parseInt(protfolioN_TextF_Assessment.getText());
        String PortfolNtext = protfolioN_TextF_Assessment.getText();
        int assesPortfolN = PortfolNtext.isEmpty() ? 0 : Integer.parseInt(PortfolNtext);

        //int assesPortfolW = Integer.parseInt(protfolioW_TextF_Assessment.getText());
        String PortfolWtext = protfolioW_TextF_Assessment.getText();
        int assesPortfolW = PortfolWtext.isEmpty() ? 0 : Integer.parseInt(PortfolWtext);

        //int assesPortfolLO = Integer.parseInt(protfolioLO_TextF_Assessment.getText());
        String PortfolLOtext = protfolioLO_TextF_Assessment.getText();
        int assesPortfolLO = PortfolLOtext.isEmpty() ? 0 : Integer.parseInt(PortfolLOtext);

        //int assesWorkshN = Integer.parseInt(workshopN_TextF_Assessment.getText());
        String WorkshNtext = workshopN_TextF_Assessment.getText();
        int assesWorkshN = WorkshNtext.isEmpty() ? 0 : Integer.parseInt(WorkshNtext);

        //int assesWorkshW = Integer.parseInt(workshopW_TextF_Assessment.getText());
        String WorkshWtext = workshopW_TextF_Assessment.getText();
        int assesWorkshW = WorkshWtext.isEmpty() ? 0 : Integer.parseInt(WorkshWtext);

        //int assesWorkshLO = Integer.parseInt(workshopLO_TextF_Assessment.getText());
        String WorkshLOtext = workshopLO_TextF_Assessment.getText();
        int assesWorkshLO = WorkshLOtext.isEmpty() ? 0 : Integer.parseInt(WorkshLOtext);

        //int assesOraleN = Integer.parseInt(oralExamN_TextF_Assessment.getText());
        String OraleNtext = oralExamN_TextF_Assessment.getText();
        int assesOraleN = OraleNtext.isEmpty() ? 0 : Integer.parseInt(OraleNtext);

        //int assesOraleW = Integer.parseInt(oralExamW_TextF_Assessment.getText());
        String OraleWtext = oralExamW_TextF_Assessment.getText();
        int assesOraleW = OraleWtext.isEmpty() ? 0 : Integer.parseInt(OraleWtext);

        //int assesOraleLO = Integer.parseInt(oralExamLO_TextF_Assessment.getText());
        String OraleLOtext = oralExamLO_TextF_Assessment.getText();
        int assesOraleLO = OraleLOtext.isEmpty() ? 0 : Integer.parseInt(OraleLOtext);

        //int assesMidtN = Integer.parseInt(midtermN_TextF_Assessment.getText());
        String MidtNtext = midtermN_TextF_Assessment.getText();
        int assesMidtN = MidtNtext.isEmpty() ? 0 : Integer.parseInt(MidtNtext);

        //int assesMidtW = Integer.parseInt(midtermW_TextF_Assessment.getText());
        String MidtWtext = midtermW_TextF_Assessment.getText();
        int assesMidtW = MidtWtext.isEmpty() ? 0 : Integer.parseInt(MidtWtext);

        //int assesMidtLO = Integer.parseInt(midtermLO_TextF_Assessment.getText());
        String MidtLOtext = midtermLO_TextF_Assessment.getText();
        int assesMidtLO = MidtLOtext.isEmpty() ? 0 : Integer.parseInt(MidtLOtext);

        //int assesFinalN = Integer.parseInt(finalExamN_TextF_Assessment.getText());
        String FinalNtext = finalExamN_TextF_Assessment.getText();
        int assesFinalN = FinalNtext.isEmpty() ? 0 : Integer.parseInt(FinalNtext);

        //int assesFinalW = Integer.parseInt(finalExamW_TextF_Assessment.getText());
        String FinalWtext = finalExamW_TextF_Assessment.getText();
        int assesFinalW = FinalWtext.isEmpty() ? 0 : Integer.parseInt(FinalWtext);

        //int assesFinalLO = Integer.parseInt(finalExamLO_TextF_Assessment.getText());
        String FinalLOtext = finalExamLO_TextF_Assessment.getText();
        int assesFinalLO = FinalLOtext.isEmpty() ? 0 : Integer.parseInt(FinalLOtext);

        //int assesWeightofSemesterN = Integer.parseInt(weightingofSemesterN_TextF_Assessment.getText());
        String WeightofSemesterNtext = weightingofSemesterN_TextF_Assessment.getText();
        int assesWeightofSemesterN = WeightofSemesterNtext.isEmpty() ? 0 : Integer.parseInt(WeightofSemesterNtext);

        //int assesWeightofSemesterW = Integer.parseInt(weightingofSemesterW_TextF_Assessment.getText());
        String WeightofSemesterWtext = weightingofSemesterW_TextF_Assessment.getText();
        int assesWeightofSemesterW = WeightofSemesterWtext.isEmpty() ? 0 : Integer.parseInt(WeightofSemesterWtext);

        //int assesWeightofSemesterLO = Integer.parseInt(weightingofSemesterLO_TextF_Assessment.getText());
        String WeightofSemesterLOtext = weightingofSemesterLO_TextF_Assessment.getText();
        int assesWeightofSemesterLO = WeightofSemesterLOtext.isEmpty() ? 0 : Integer.parseInt(WeightofSemesterLOtext);

        //int assesWeightofEndofSemesterN = Integer.parseInt(weightingofEndSemesterN_TextF_Assessment.getText());
        String WeightofEndofSemesterNtext = weightingofEndSemesterN_TextF_Assessment.getText();
        int assesWeightofEndofSemesterN = WeightofEndofSemesterNtext.isEmpty() ? 0 : Integer.parseInt(WeightofEndofSemesterNtext);

        //int assesWeightofEndofSemesterW = Integer.parseInt(weightingofEndSemesterW_TextF_Assessment.getText());
        String WeightofEndofSemesterWtext = weightingofEndSemesterW_TextF_Assessment.getText();
        int assesWeightofEndofSemesterW = WeightofEndofSemesterWtext.isEmpty() ? 0 : Integer.parseInt(WeightofEndofSemesterWtext);

        //int assesWeightofEndofSemesterLO = Integer.parseInt(weightingofEndSemesterLO_TextF_Assessment.getText());
        String WeightofEndofSemesterLOtext = weightingofEndSemesterLO_TextF_Assessment.getText();
        int assesWeightofEndofSemesterLO = WeightofEndofSemesterLOtext.isEmpty() ? 0 : Integer.parseInt(WeightofEndofSemesterLOtext);


        int totalweight = 0;
        List<Integer> assesmentWeight = Arrays.asList(
                assesParticipW, assesLabW, assesFiledW, assesQuizW, assesHomewW, assesPresentW, assesProjectW, assesPortfolW,
                assesWorkshW, assesOraleW, assesMidtW, assesFinalW, assesWeightofSemesterW, assesWeightofEndofSemesterW
        );
        for (Integer value : assesmentWeight) {
            if (value == null) {
                continue;
            }

            totalweight += value;

        }
        if (totalweight != 100) {
            saveallkey = false;
            b.setAlertType(Alert.AlertType.WARNING);
            b.setHeaderText(" Total weight must be 100 ");
            b.show();
        }

        //ECTS / Workload Table

        //course hour
        String CoursehourNtext = courseHourN_TextF_WorkloadTable.getText();
        int ectsCoursehourN = CoursehourNtext.isEmpty() ? 0 : Integer.parseInt(CoursehourNtext);

        String CoursehourDHtext = courseHourDH_TextF_WorkloadTable.getText();
        int ectsCoursehourDH = CoursehourDHtext.isEmpty() ? 0 : Integer.parseInt(CoursehourDHtext);

        String CoursehourWtext = courseHourW_TextF_WorkloadTable.getText();
        int ectsCoursehourW = CoursehourWtext.isEmpty() ? 0 : Integer.parseInt(CoursehourWtext);

        //lab hour
        String LabhourNtext = LabHourN_TextF_WorkloadTable.getText();
        int ectsLabhourN = LabhourNtext.isEmpty() ? 0 : Integer.parseInt(LabhourNtext);

        String LabhourDHtext = LabHourDH_TextF_WorkloadTable.getText();
        int ectsLabhourDH = LabhourDHtext.isEmpty() ? 0 : Integer.parseInt(LabhourDHtext);

        String LabhourWtext = LabHourW_TextF_WorkloadTable.getText();
        int ectsLabhourW = LabhourWtext.isEmpty() ? 0 : Integer.parseInt(LabhourWtext);
        //study hour
        String StudyhourNtext = studyHourN_TextF_WorkloadTable.getText();
        int ectsStudyhourN = StudyhourNtext.isEmpty() ? 0 : Integer.parseInt(StudyhourNtext);

        String StudyhourDHtext = studyHourDH_TextF_WorkloadTable.getText();
        int ectsStudyhourDH = StudyhourDHtext.isEmpty() ? 0 : Integer.parseInt(StudyhourDHtext);

        String StudyhourWtext = studyHourW_TextF_WorkloadTable.getText();
        int ectsStudyhourW = StudyhourWtext.isEmpty() ? 0 : Integer.parseInt(StudyhourWtext);
        //field work
        String FieldworkNtext = fieldWN_TextF_WorkloadTable.getText();
        int ectsFieldworkN = FieldworkNtext.isEmpty() ? 0 : Integer.parseInt(FieldworkNtext);

        String FieldworkDHtext = fieldWDH_TextF_WorkloadTable.getText();
        int ectsFieldworkDH = FieldworkDHtext.isEmpty() ? 0 : Integer.parseInt(FieldworkDHtext);

        String FieldworkWtext = fieldWW_TextF_WorkloadTable.getText();
        int ectsFieldworkW = FieldworkWtext.isEmpty() ? 0 : Integer.parseInt(FieldworkWtext);
        //quiz
        String quizNtext = quizN_TextF_WorkloadTable.getText();
        int ectsQuizN = quizNtext.isEmpty() ? 0 : Integer.parseInt(quizNtext);

        String quizDHtext = quizDH_TextF_WorkloadTable.getText();
        int ectsQuizDH = quizDHtext.isEmpty() ? 0 : Integer.parseInt(quizDHtext);

        String quizWtext = quizW_TextF_WorkloadTable.getText();
        int ectsQuizW = quizWtext.isEmpty() ? 0 : Integer.parseInt(quizWtext);
        //homework
        String HomeworkNtext = homeWN_TextF_WorkloadTable.getText();
        int ectsHomeworkN = HomeworkNtext.isEmpty() ? 0 : Integer.parseInt(HomeworkNtext);

        String HomeworkDHtext = homeWDH_TextF_WorkloadTable.getText();
        int ectsHomeworkDH = HomeworkDHtext.isEmpty() ? 0 : Integer.parseInt(HomeworkDHtext);

        String HomeworkWtext = homeWW_TextF_WorkloadTable.getText();
        int ectsHomeworkW = HomeworkWtext.isEmpty() ? 0 : Integer.parseInt(HomeworkWtext);
        //presentation
        String PresentationNtext = presentationN_TextF_WorkloadTable.getText();
        int ectsPresentationN = PresentationNtext.isEmpty() ? 0 : Integer.parseInt(PresentationNtext);

        String PresentationDHtext = presentationDH_TextF_WorkloadTable.getText();
        int ectsPresentationDH = PresentationDHtext.isEmpty() ? 0 : Integer.parseInt(PresentationDHtext);

        String PresentationWtext = presentationW_TextF_WorkloadTable.getText();
        int ectsPresentationW = PresentationWtext.isEmpty() ? 0 : Integer.parseInt(PresentationWtext);
        //project
        String ectsProjectNtext = projectN_TextF_WorkloadTable.getText();
        int ectsProjectN = ectsProjectNtext.isEmpty() ? 0 : Integer.parseInt(ectsProjectNtext);

        String ectsProjectDHtext = projectDH_TextF_WorkloadTable.getText();
        int ectsProjectDH = ectsProjectDHtext.isEmpty() ? 0 : Integer.parseInt(ectsProjectDHtext);

        String ectsProjectWtext = projectW_TextF_WorkloadTable.getText();
        int ectsProjectW = ectsProjectWtext.isEmpty() ? 0 : Integer.parseInt(ectsProjectWtext);
        //portfolio
        String PortfolioNtext = portfolioN_TextF_WorkloadTable.getText();
        int ectsPortfolioN = PortfolioNtext.isEmpty() ? 0 : Integer.parseInt(PortfolioNtext);

        String PortfolioDHtext = portfolioDH_TextF_WorkloadTable.getText();
        int ectsPortfolioDH = PortfolioDHtext.isEmpty() ? 0 : Integer.parseInt(PortfolioDHtext);

        String PortfolioWtext = portfolioW_TextF_WorkloadTable.getText();
        int ectsPortfolioW = PortfolioWtext.isEmpty() ? 0 : Integer.parseInt(PortfolioWtext);
        //seminar workshop
        String WorkshopNtext = workshopN_TextF_WorkloadTable.getText();
        int ectsWorkshopN = WorkshopNtext.isEmpty() ? 0 : Integer.parseInt(WorkshopNtext);

        String WorkshopDHtext = workshopDH_TextF_WorkloadTable.getText();
        int ectsWorkshopDH = WorkshopDHtext.isEmpty() ? 0 : Integer.parseInt(WorkshopDHtext);

        String WorkshopWtext = workshopW_TextF_WorkloadTable.getText();
        int ectsWorkshopW = WorkshopWtext.isEmpty() ? 0 : Integer.parseInt(WorkshopWtext);
        //oral exam
        String OralexamNtext = oralExamN_TextF_WorkloadTable.getText();
        int ectsOralexamN = OralexamNtext.isEmpty() ? 0 : Integer.parseInt(OralexamNtext);

        String OralexamDHtext = oralExamDH_TextF_WorkloadTable.getText();
        int ectsOralexamDH = OralexamDHtext.isEmpty() ? 0 : Integer.parseInt(OralexamDHtext);

        String OralexamWtext = oralExamW_TextF_WorkloadTable.getText();
        int ectsOralexamW = OralexamWtext.isEmpty() ? 0 : Integer.parseInt(OralexamWtext);
        //midterm
        String MidtermNtext = midtermN_TextF_WorkloadTable.getText();
        int ectsMidtermN = MidtermNtext.isEmpty() ? 0 : Integer.parseInt(MidtermNtext);

        String MidtermDHtext = midtermDH_TextF_WorkloadTable.getText();
        int ectsMidtermDH = MidtermDHtext.isEmpty() ? 0 : Integer.parseInt(MidtermDHtext);

        String MidtermWtext = midtermW_TextF_WorkloadTable.getText();
        int ectsMidtermW = MidtermWtext.isEmpty() ? 0 : Integer.parseInt(MidtermWtext);
        //final
        String ectsFinalNtext = finalExamN_TextF_WorkloadTable.getText();
        int ectsFinalN = ectsFinalNtext.isEmpty() ? 0 : Integer.parseInt(ectsFinalNtext);

        String ectsFinalDHtext = finalExamDH_TextF_WorkloadTable.getText();
        int ectsFinalDH = ectsFinalDHtext.isEmpty() ? 0 : Integer.parseInt(ectsFinalDHtext);

        String ectsFinalWtext = finalExamW_TextF_WorkloadTable.getText();
        int ectsFinalW = ectsFinalWtext.isEmpty() ? 0 : Integer.parseInt(ectsFinalWtext);

        ArrayList<ProgramOutcomedata> outcomeMatrix = new ArrayList<ProgramOutcomedata>();
        for (ProgramOutcomedata outcome : table_OutcomeMatrixt.getItems()) {
            System.out.println("outcomes: " + outcome.getOutcomesTableView() + ", contribution level: " + outcome.getContributionLevel() + " LO: " + outcome.getLO());
            outcomeMatrix.add(outcome);
        }

        if (!saveallkey) {
            a.setAlertType(Alert.AlertType.WARNING);
            a.setHeaderText(" All sections must be filled ");
            a.show();
        } else {
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setHeaderText(" All saved ");
            a.show();
            Syllabus newSyllabus = new Syllabus(generalInfo_Code, generalInfo_FallSpring, generalInfo_Theory, generalInfo_Lab, generalInfo_localCredits,
                    generalInfo_Prerequisites, generalInfo_courseLanguage, generalInfo_courseType, generalInfo_courseLevel,
                    generalInfo_Modeofdelivery, generalInfo_Teachingmethods, generalInfo_CourseCoordinator, generalInfo_CourseLecturer,
                    generalInfo_CourseAssistant, generalInfo_CourseObjectives, generalInfo_Learningoutcomes, generalInfo_CourseCategory,

                    weeklysub_1sub, weeklysub_1req, weeklysub_2sub, weeklysub_2req, weeklysub_3sub, weeklysub_3req,
                    weeklysub_4sub, weeklysub_4req, weeklysub_5sub, weeklysub_5req, weeklysub_6sub, weeklysub_6req,
                    weeklysub_7sub, weeklysub_7req, weeklysub_8sub, weeklysub_8req, weeklysub_9sub, weeklysub_9req,
                    weeklysub_10sub, weeklysub_10req, weeklysub_11sub, weeklysub_11req, weeklysub_12sub, weeklysub_12req,
                    weeklysub_13sub, weeklysub_13req, weeklysub_14sub, weeklysub_14req, weeklysub_15sub, weeklysub_15req,
                    weeklysub_16sub, weeklysub_16req, weeklysub_coursenotes, weeklysub_suggmat,

                    assesParticipN, assesParticipW, assesParticipLO, assesLabN, assesLabW, assesLabLO,
                    assesFiledN, assesFiledW, assesFiledLO, assesQuizN, assesQuizW, assesQuizLO,
                    assesHomewN, assesHomewW, assesHomewLO, assesPresentN, assesPresentW, assesPresentLO,
                    assesProjectN, assesProjectW, assesProjectLO, assesPortfolN, assesPortfolW, assesPortfolLO,
                    assesWorkshN, assesWorkshW, assesWorkshLO, assesOraleN, assesOraleW, assesOraleLO,
                    assesMidtN, assesMidtW, assesMidtLO, assesFinalN, assesFinalW, assesFinalLO,
                    assesWeightofSemesterN, assesWeightofSemesterW, assesWeightofSemesterLO,
                    assesWeightofEndofSemesterN, assesWeightofEndofSemesterW, assesWeightofEndofSemesterLO,

                    ectsCoursehourN, ectsCoursehourDH, ectsCoursehourW, ectsLabhourN, ectsLabhourDH, ectsLabhourW,
                    ectsStudyhourN, ectsStudyhourDH, ectsStudyhourW, ectsFieldworkN, ectsFieldworkDH, ectsFieldworkW,
                    ectsQuizN, ectsQuizDH, ectsQuizW, ectsHomeworkN, ectsHomeworkDH, ectsHomeworkW,
                    ectsPresentationN, ectsPresentationDH, ectsPresentationW, ectsProjectN, ectsProjectDH, ectsProjectW,
                    ectsPortfolioN, ectsPortfolioDH, ectsPortfolioW, ectsWorkshopN, ectsWorkshopDH, ectsWorkshopW,
                    ectsOralexamN, ectsOralexamDH, ectsOralexamW, ectsMidtermN, ectsMidtermDH, ectsMidtermW,
                    ectsFinalN, ectsFinalDH, ectsFinalW,
                    outcomeMatrix);

            DBConnector.getInstance().addCourseInformationTable(newSyllabus);
            DBConnector.getInstance().addCourseWeeklySchedule(newSyllabus);
            DBConnector.getInstance().addCourseAssessmentTable(newSyllabus);
            DBConnector.getInstance().addCourseWorkloadTable(newSyllabus);
            DBConnector.getInstance().addCourseMainTable(newSyllabus);
            DBConnector.getInstance().addCourseOutcomeTable(++numberOfOutcomes, LO_TextF_GeneralInf.getText(), programCompetencies_TextF_CourseOutcomes.getText(), outcomematix_contributionlevel());

        }

    }
}