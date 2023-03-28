import {defineStore} from "pinia";

export const useBoardStore = defineStore('boardStore', {
    state : () => ({
        board : {},
        loading : false,
    }),

    getters : {
        getBoard(state) {
            return state.board;
        }
    },

    actions : {
        async fetchDataForServer(id) {
            try {
                const data = await fetch(`http://localhost:8080/api/list/${id}`);
                this.board = await data.json();
                this.loading = true;
            } catch (e) {
                console.log(e);
            }
        },

        async fetchDataForClient(id) {
            try {
                const data = await fetch(`/api/list/${id}`);
                this.board = await data.json();
                this.loading = true;
            } catch (e) {
                console.log(e);
            }
        },

        unmountData(){
            this.board = {};
            this.loading = false;
        }
    }
})