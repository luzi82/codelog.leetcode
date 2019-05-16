class Solution(object):
    def lengthLongestPath(self, iinput):
        """
        :type input: str
        :rtype: int
        """
        line_list = iinput.split('\n')

        max_file_len = 0
        prefix_len_list = [0]
        
        for line in line_list:
            level = 0
            while line[level] == '\t':
                level+=1
            while(len(prefix_len_list)>level+1):
                prefix_len_list.pop()
            name = line[level:]
            is_file = '.' in line
            if is_file:
                file_len = prefix_len_list[level] + len(name)
                if file_len > max_file_len:
                    max_file_len = file_len
            else:
                prefix_len_list.append(prefix_len_list[level] + len(name) + 1)
        
        return max_file_len
