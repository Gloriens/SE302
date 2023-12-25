package com.example.syllabusmanager;

import java.util.ArrayList;

public class Syllabus {


    //section 1

    String GI_code;
    int GI_call_spring;
    String GI_theory;
    String GI_lab;
    int GIl_ocalcredit;
    String GI_prequisities;
    int GI_language;
    int GI_type;
    int GI_level;
    int GI_modeofdelivery;
    String GI_teachingmethods;
    String GI_coordinator;
    String GI_lecturer;
    String GI_assistant;
    String GI_objectives;
    String GI_learningoutcomes;
    int GI_coursecategory;


    //section 2
    String W1sub;
    String W1req;
    String W2sub;
    String W2req;
    String W3sub;
    String W3req;
    String W4sub;
    String W4req;
    String W5sub;
    String W5req;
    String W6sub;
    String W6req;
    String W7sub;
    String W7req;
    String W8sub;
    String W8req;
    String W9sub;
    String W9req;
    String W10sub;
    String W10req;
    String W11sub;
    String W11req;
    String W12sub;
    String W12req;
    String W13sub;
    String W13req;
    String W14sub;
    String W14req;
    String W15sub;
    String W15req;
    String W16sub;
    String W16req;
    String courseNotesTextbooks;
    String SuggestedReadings;

    //section 3
    int AssesParticip_N;
    int AssesParticip_W;
    int AssesParticip_LO;
    int AssesLab_N;
    int AssesLab_W;
    int AssesLab_LO;
    int AssesFieldwork_N;
    int AssesFieldwork_W;
    int AssesFieldwork_LO;
    int AssesQuiz_N;
    int AssesQuiz_W;
    int AssesQuiz_LO;
    int AssesHomework_N;
    int AssesHomework_W;
    int AssesHomework_LO;
    int AssesPresentation_N;
    int AssesPresentation_W;
    int AssesPresentation_LO;
    int AssesProject_N;
    int AssesProject_W;
    int AssesProject_LO;
    int AssesPortfolio_N;
    int AssesPortfolio_W;
    int AssesPortfolio_LO;
    int AssesSeminar_N;
    int AssesSeminar_W;
    int AssesSeminar_LO;
    int AssesOralexam_N;
    int AssesOralexam_W;
    int AssesOralexam_LO;
    int AssesMidterm_N;
    int AssesMidterm_W;
    int AssesMidterm_LO;
    int AssesFinal_N;
    int AssesFinal_W;
    int AssesFinal_LO;
    int AssesWeightingofSemesterActivitiesontheFinalGrade_N;
    int AssesWeightingofSemesterActivitiesontheFinalGrade_W;
    int AssesWeightingofSemesterActivitiesontheFinalGrade_LO;
    int AssesWeightingofEndofSemesterActivitiesontheFinalGrade_N;
    int AssesWeightingofEndofSemesterActivitiesontheFinalGrade_W;
    int AssesWeightingofEndofSemesterActivitiesontheFinalGrade_LO;

    //section 4
    int WLTableCoursehours_N;
    int WLTableCoursehours_DH;
    int WLTableCoursehours_W;
    int WLTableLabhours_N;
    int WLTableLabhours_DH;
    int WLTableLabhours_W;
    int WLTableStudyhoursoutofclass_N;
    int WLTableStudyhoursoutofclass_DH;
    int WLTableStudyhoursoutofclass_W;
    int WLTableFieldwork_N;
    int WLTableFieldwork_DH;
    int WLTableFieldwork_W;
    int WLTableQuiz_N;
    int WLTableQuiz_DH;
    int WLTableQuiz_W;
    int WLTableHomework_N;
    int WLTableHomework_DH;
    int WLTableHomework_W;
    int WLTablePresentation_N;
    int WLTablePresentation_DH;
    int WLTablePresentation_W;
    int WLTableProject_N;
    int WLTableProject_DH;
    int WLTableProject_W;
    int WLTablePortfolio_N;
    int WLTablePortfolio_DH;
    int WLTablePortfolio_W;
    int WLTableSeminar_N;
    int WLTableSeminar_DH;
    int WLTableSeminar_W;
    int WLTableOralexam_N;
    int WLTableOralexam_DH;
    int WLTableOralexam_W;
    int WLTableMidterm_N;
    int WLTableMidterm_DH;
    int WLTableMidterm_W;
    int WLTableFinal_N;
    int WLTableFinal_DH;
    int WLTableFinal_W;

    //section 5
    ArrayList<CreateSyllabusController.ProgramOutcomedata> outcomeMatrix;

    public Syllabus(String GI_code, int GI_call_spring, String GI_theory, String GI_lab,
                    int GIl_ocalcredit, String GI_prequisities, int GI_language, int GI_type, int GI_level,
                    int GI_modeofdelivery, String GI_teachingmethods, String GI_coordinator, String GI_lecturer,
                    String GI_assistant, String GI_objectives, String GI_learningoutcomes, int GI_coursecategory,

                    String w1sub, String w1req, String w2sub, String w2req, String w3sub, String w3req, String w4sub,
                    String w4req, String w5sub, String w5req, String w6sub, String w6req, String w7sub, String w7req,
                    String w8sub, String w8req, String w9sub, String w9req, String w10sub, String w10req, String w11sub,
                    String w11req, String w12sub, String w12req, String w13sub, String w13req, String w14sub, String w14req,
                    String w15sub, String w15req, String w16sub, String w16req, String courseNotesTextbooks, String suggestedReadings,

                    int assesParticip_N, int assesParticip_W, int assesParticip_LO, int assesLab_N,
                    int assesLab_W, int assesLab_LO, int assesFieldwork_N, int assesFieldwork_W, int assesFieldwork_LO,
                    int assesQuiz_N, int assesQuiz_W, int assesQuiz_LO, int assesHomework_N, int assesHomework_W,
                    int assesHomework_LO, int assesPresentation_N, int assesPresentation_W, int assesPresentation_LO,
                    int assesProject_N, int assesProject_W, int assesProject_LO, int assesPortfolio_N, int assesPortfolio_W,
                    int assesPortfolio_LO, int assesSeminar_N, int assesSeminar_W, int assesSeminar_LO, int assesOralexam_N,
                    int assesOralexam_W, int assesOralexam_LO, int assesMidterm_N, int assesMidterm_W, int assesMidterm_LO,
                    int assesFinal_N, int assesFinal_W, int assesFinal_LO,
                    int assesWeightingofSemesterActivitiesontheFinalGrade_N, int assesWeightingofSemesterActivitiesontheFinalGrade_W, int assesWeightingofSemesterActivitiesontheFinalGrade_LO,
                    int assesWeightingofEndofSemesterActivitiesontheFinalGrade_N, int assesWeightingofEndofSemesterActivitiesontheFinalGrade_W, int assesWeightingofEndofSemesterActivitiesontheFinalGrade_LO,

                    int WLTableCoursehours_N, int WLTableCoursehours_DH,
                    int WLTableCoursehours_W, int WLTableLabhours_N, int WLTableLabhours_DH, int WLTableLabhours_W,
                    int WLTableStudyhoursoutofclass_N, int WLTableStudyhoursoutofclass_DH, int WLTableStudyhoursoutofclass_W,
                    int WLTableFieldwork_N, int WLTableFieldwork_DH, int WLTableFieldwork_W, int WLTableQuiz_N, int WLTableQuiz_DH,
                    int WLTableQuiz_W, int WLTableHomework_N, int WLTableHomework_DH, int WLTableHomework_W,
                    int WLTablePresentation_N, int WLTablePresentation_DH, int WLTablePresentation_W, int WLTableProject_N,
                    int WLTableProject_DH, int WLTableProject_W, int WLTablePortfolio_N, int WLTablePortfolio_DH,
                    int WLTablePortfolio_W, int WLTableSeminar_N, int WLTableSeminar_DH, int WLTableSeminar_W,
                    int WLTableOralexam_N, int WLTableOralexam_DH, int WLTableOralexam_W, int WLTableMidterm_N,
                    int WLTableMidterm_DH, int WLTableMidterm_W, int WLTableFinal_N, int WLTableFinal_DH, int WLTableFinal_W,
                    ArrayList<CreateSyllabusController.ProgramOutcomedata> outcomeMatrix) {

        this.GI_code = GI_code;
        this.GI_call_spring = GI_call_spring;
        this.GI_theory = GI_theory;
        this.GI_lab = GI_lab;
        this.GIl_ocalcredit = GIl_ocalcredit;
        this.GI_prequisities = GI_prequisities;
        this.GI_language = GI_language;
        this.GI_type = GI_type;
        this.GI_level = GI_level;
        this.GI_modeofdelivery = GI_modeofdelivery;
        this.GI_teachingmethods = GI_teachingmethods;
        this.GI_coordinator = GI_coordinator;
        this.GI_lecturer = GI_lecturer;
        this.GI_assistant = GI_assistant;
        this.GI_objectives = GI_objectives;
        this.GI_learningoutcomes = GI_learningoutcomes;
        this.GI_coursecategory = GI_coursecategory;
        W1sub = w1sub;
        W1req = w1req;
        W2sub = w2sub;
        W2req = w2req;
        W3sub = w3sub;
        W3req = w3req;
        W4sub = w4sub;
        W4req = w4req;
        W5sub = w5sub;
        W5req = w5req;
        W6sub = w6sub;
        W6req = w6req;
        W7sub = w7sub;
        W7req = w7req;
        W8sub = w8sub;
        W8req = w8req;
        W9sub = w9sub;
        W9req = w9req;
        W10sub = w10sub;
        W10req = w10req;
        W11sub = w11sub;
        W11req = w11req;
        W12sub = w12sub;
        W12req = w12req;
        W13sub = w13sub;
        W13req = w13req;
        W14sub = w14sub;
        W14req = w14req;
        W15sub = w15sub;
        W15req = w15req;
        W16sub = w16sub;
        W16req = w16req;
        this.courseNotesTextbooks = courseNotesTextbooks;
        SuggestedReadings = suggestedReadings;
        AssesParticip_N = assesParticip_N;
        AssesParticip_W = assesParticip_W;
        AssesParticip_LO = assesParticip_LO;
        AssesLab_N = assesLab_N;
        AssesLab_W = assesLab_W;
        AssesLab_LO = assesLab_LO;
        AssesFieldwork_N = assesFieldwork_N;
        AssesFieldwork_W = assesFieldwork_W;
        AssesFieldwork_LO = assesFieldwork_LO;
        AssesQuiz_N = assesQuiz_N;
        AssesQuiz_W = assesQuiz_W;
        AssesQuiz_LO = assesQuiz_LO;
        AssesHomework_N = assesHomework_N;
        AssesHomework_W = assesHomework_W;
        AssesHomework_LO = assesHomework_LO;
        AssesPresentation_N = assesPresentation_N;
        AssesPresentation_W = assesPresentation_W;
        AssesPresentation_LO = assesPresentation_LO;
        AssesProject_N = assesProject_N;
        AssesProject_W = assesProject_W;
        AssesProject_LO = assesProject_LO;
        AssesPortfolio_N = assesPortfolio_N;
        AssesPortfolio_W = assesPortfolio_W;
        AssesPortfolio_LO = assesPortfolio_LO;
        AssesSeminar_N = assesSeminar_N;
        AssesSeminar_W = assesSeminar_W;
        AssesSeminar_LO = assesSeminar_LO;
        AssesOralexam_N = assesOralexam_N;
        AssesOralexam_W = assesOralexam_W;
        AssesOralexam_LO = assesOralexam_LO;
        AssesMidterm_N = assesMidterm_N;
        AssesMidterm_W = assesMidterm_W;
        AssesMidterm_LO = assesMidterm_LO;
        AssesFinal_N = assesFinal_N;
        AssesFinal_W = assesFinal_W;
        AssesFinal_LO = assesFinal_LO;
        AssesWeightingofSemesterActivitiesontheFinalGrade_N = assesWeightingofSemesterActivitiesontheFinalGrade_N;
        AssesWeightingofSemesterActivitiesontheFinalGrade_W = assesWeightingofSemesterActivitiesontheFinalGrade_W;
        AssesWeightingofSemesterActivitiesontheFinalGrade_LO = assesWeightingofSemesterActivitiesontheFinalGrade_LO;
        AssesWeightingofEndofSemesterActivitiesontheFinalGrade_N = assesWeightingofEndofSemesterActivitiesontheFinalGrade_N;
        AssesWeightingofEndofSemesterActivitiesontheFinalGrade_W = assesWeightingofEndofSemesterActivitiesontheFinalGrade_W;
        AssesWeightingofEndofSemesterActivitiesontheFinalGrade_LO = assesWeightingofEndofSemesterActivitiesontheFinalGrade_LO;
        this.WLTableCoursehours_N = WLTableCoursehours_N;
        this.WLTableCoursehours_DH = WLTableCoursehours_DH;
        this.WLTableCoursehours_W = WLTableCoursehours_W;
        this.WLTableLabhours_N = WLTableLabhours_N;
        this.WLTableLabhours_DH = WLTableLabhours_DH;
        this.WLTableLabhours_W = WLTableLabhours_W;
        this.WLTableStudyhoursoutofclass_N = WLTableStudyhoursoutofclass_N;
        this.WLTableStudyhoursoutofclass_DH = WLTableStudyhoursoutofclass_DH;
        this.WLTableStudyhoursoutofclass_W = WLTableStudyhoursoutofclass_W;
        this.WLTableFieldwork_N = WLTableFieldwork_N;
        this.WLTableFieldwork_DH = WLTableFieldwork_DH;
        this.WLTableFieldwork_W = WLTableFieldwork_W;
        this.WLTableQuiz_N = WLTableQuiz_N;
        this.WLTableQuiz_DH = WLTableQuiz_DH;
        this.WLTableQuiz_W = WLTableQuiz_W;
        this.WLTableHomework_N = WLTableHomework_N;
        this.WLTableHomework_DH = WLTableHomework_DH;
        this.WLTableHomework_W = WLTableHomework_W;
        this.WLTablePresentation_N = WLTablePresentation_N;
        this.WLTablePresentation_DH = WLTablePresentation_DH;
        this.WLTablePresentation_W = WLTablePresentation_W;
        this.WLTableProject_N = WLTableProject_N;
        this.WLTableProject_DH = WLTableProject_DH;
        this.WLTableProject_W = WLTableProject_W;
        this.WLTablePortfolio_N = WLTablePortfolio_N;
        this.WLTablePortfolio_DH = WLTablePortfolio_DH;
        this.WLTablePortfolio_W = WLTablePortfolio_W;
        this.WLTableSeminar_N = WLTableSeminar_N;
        this.WLTableSeminar_DH = WLTableSeminar_DH;
        this.WLTableSeminar_W = WLTableSeminar_W;
        this.WLTableOralexam_N = WLTableOralexam_N;
        this.WLTableOralexam_DH = WLTableOralexam_DH;
        this.WLTableOralexam_W = WLTableOralexam_W;
        this.WLTableMidterm_N = WLTableMidterm_N;
        this.WLTableMidterm_DH = WLTableMidterm_DH;
        this.WLTableMidterm_W = WLTableMidterm_W;
        this.WLTableFinal_N = WLTableFinal_N;
        this.WLTableFinal_DH = WLTableFinal_DH;
        this.WLTableFinal_W = WLTableFinal_W;
        this.outcomeMatrix = outcomeMatrix;

    }
}