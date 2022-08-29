package com.sist.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
  private String name,sex,loc,content;
  private String[] hobby;
}
