<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>CoverImagePath</th>
                        <th>SummaryContent</th>
                        <th>BookName</th>
                        <th>PdfPath</th>
                        <th>AuthorId</th>
                        <th>AuthorName</th>
                        <th>Category</th>
                        <th>NotifyStatus</th>
                        <th>원고 ID</th>
                        <th>ChatGPT</th>
                        <th>원고</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="CoverImagePath">{{ val.coverImagePath }}</td>
                            <td class="whitespace-nowrap" label="SummaryContent">{{ val.summaryContent }}</td>
                            <td class="whitespace-nowrap" label="BookName">{{ val.bookName }}</td>
                            <td class="whitespace-nowrap" label="PdfPath">{{ val.pdfPath }}</td>
                            <td class="whitespace-nowrap" label="AuthorId">{{ val.authorId }}</td>
                            <td class="whitespace-nowrap" label="AuthorName">{{ val.authorName }}</td>
                            <td class="whitespace-nowrap" label="Category">{{ val.category }}</td>
                            <td class="whitespace-nowrap" label="NotifyStatus">{{ val.notifyStatus }}</td>
                            <td class="whitespace-nowrap" label="ChatGPT">
                                <GptId :editMode="editMode" v-model="val.gptId"></GptId>
                            </td>
                            <td class="whitespace-nowrap" label="원고">
                                <ManuscriptId :editMode="editMode" v-model="val.manuscriptId"></ManuscriptId>
                            </td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Publishing 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Publishing :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Publishing 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="CoverImagePath" v-model="selectedRow.coverImagePath" :editMode="true"/>
                            <String label="SummaryContent" v-model="selectedRow.summaryContent" :editMode="true"/>
                            <String label="BookName" v-model="selectedRow.bookName" :editMode="true"/>
                            <String label="PdfPath" v-model="selectedRow.pdfPath" :editMode="true"/>
                            <String label="AuthorId" v-model="selectedRow.authorId" :editMode="true"/>
                            <String label="AuthorName" v-model="selectedRow.authorName" :editMode="true"/>
                            <String label="Category" v-model="selectedRow.category" :editMode="true"/>
                            <Boolean label="NotifyStatus" v-model="selectedRow.notifyStatus" :editMode="true"/>
                            <ManuscriptId offline label="원고 ID" v-model="selectedRow.manuscriptId" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'publishingGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'publishings',
    }),
    watch: {
    },
    methods:{
    }
}

</script>