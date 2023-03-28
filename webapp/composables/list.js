export const useList = () => {
    return useState('list', async () => {
        let {pending , data , error} = await useFetch('http://localhost:8080/api/list');
        return data;
    });
}