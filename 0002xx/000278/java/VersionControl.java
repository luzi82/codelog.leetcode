class VersionControl{

  int firstBadVersion;

  void setFirstBadVersion(int bad){
    firstBadVersion=bad;
  }
  
  boolean isBadVersion(int version){
    return version >= firstBadVersion;
  }

}
