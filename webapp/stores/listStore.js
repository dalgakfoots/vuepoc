import {defineStore} from "pinia";

export const useListStore = defineStore('listStore', {
    state: () => ({
        list : [],
    }),
    getters : {
        getList(state) {
            return state.list
        }
    },
    actions : {
        async fetchListForServer() {
            try {
                const data = await fetch('http://localhost:8080/api/list');
                const temp = await data.json();
                this.list = temp;
            } catch (e) {
                console.log(e);
            }
        } ,
        async fetchListForClient() {
            try {
                const data = await fetch('/api/list');
                const temp = await data.json();
                this.list = temp;
            } catch (e) {
                console.log(e);
            }
        }
    }
})