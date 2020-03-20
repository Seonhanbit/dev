import React, { useContext, useEffect, useState, Fragment } from 'react';

import UserVoteList from '../components/main/UserVoteList';
import UserVoteCandidateList from '../components/main/UserVoteCandidateList';
import VoteListContext from '../context/VoteListContext';

import axios from 'axios';

import {
  LinearProgress,
} from "@material-ui/core";

const UserVoteBody = props => {
  const [votenumber, setVoteNumber] = useState(null);
  const [votename, setVoteName] = useState(null);
  const [candidatelist, setCandidateList] = useState(null);
  const [endvote, setEndVote] = useState(false);
  const [scrollheight, setScrollHeight] = useState(0);
  const [selectname, setSelectName] = useState(null);
  const [loading, setLoading] = useState(null);

  const votelist = useContext(VoteListContext);

  useEffect(() => {
    setLoading(true)
    for (let [vote, candidate] of votelist) {
      if (votenumber === vote.code) {
        setVoteName(vote.name)
        setCandidateList(candidate)
      }
    }

    let nullCnt = 0
    for (let candidate of props.result.values()) {
      if (candidate === null) {
        nullCnt += 1
      }
    }
    if (nullCnt === 0) {
      setEndVote(true)
    }

    setLoading(false)
  }, [votenumber])

  const finishVote = () => {
    let candidatestring = props.user.toString() + '/'
    for (let candidatecode of props.result.values()) {
      candidatestring = candidatestring + candidatecode.toString() + ','
    }
    // back에 넘겨주는 string
    // console.log('data', candidatestring)

    // axios
    axios.put(
      'http://54.180.134.217:8080/api/candi/updateCandiList/'
      + candidatestring)
    .then(res => console.log(res))
    .catch(error => console.log(error))
    
    sessionStorage.clear();

    props.setStatus('finish')
  }

  if (loading === false) {
    if (votenumber === null) {
      return (
        <Fragment>
          <UserVoteList
            username={props.username}
            endvote={endvote}
            finishVote={finishVote}
            setVoteNumber={setVoteNumber}
            result={props.result}
            scrollheight={scrollheight}
            setScrollHeight={setScrollHeight}
            setSelectName={setSelectName}
          />
        </Fragment>
      )
    } else {
      return (
        <Fragment>
          <UserVoteCandidateList
            votenumber={votenumber}
            setVoteNumber={setVoteNumber}
            votename={votename}
            candidatelist={candidatelist}
            result={props.result}
            setResult={props.setResult}
            scrollheight={scrollheight}
            selectname={selectname}
          />
        </Fragment>
      )
    }
  } else {
    return (
      <Fragment>
        <LinearProgress />
      </Fragment>
    )
  }
}

export default UserVoteBody;