class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long totalSkill = (long)skill[0]+(long)skill[skill.length-1];
        long answer =0;
        answer = (long)skill[0]*(long)skill[skill.length-1];
        int i=1;
        while(i<skill.length-1-i){
            long currSkill =  (long)skill[i]+(long)skill[skill.length-1-i];
            if(currSkill!=totalSkill) return -1;
            answer+= (long)skill[i]*(long)skill[skill.length-1-i];
            i++;
        
        }
        return answer;
    }
}