class Solution {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        // return accounts.map{it.sum()}.max()?:0;
        return accounts.asSequence.map{it.sum()}.maxOrNull()?:0;
    }
}
